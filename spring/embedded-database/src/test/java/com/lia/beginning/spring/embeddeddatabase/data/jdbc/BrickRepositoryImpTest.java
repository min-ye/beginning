package com.lia.beginning.spring.embeddeddatabase.data.jdbc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lia.beginning.spring.embeddeddatabase.data.jdbc.BrickRepositoryImp;
import com.lia.beginning.spring.embeddeddatabase.model.Brick;
import com.lia.beginning.spring.embeddeddatabase.config.JDBCConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JDBCConfig.class)
public class BrickRepositoryImpTest {

  @Autowired
  BrickRepository brickRepository;

  @Test
  public void count() {
    assertEquals(1, brickRepository.count());
  }

  @Test
  @Transactional
  public void fetchAll() {
    List<Brick> brickList = brickRepository.fetchAll();
    assertEquals(1, brickList.size());
    assertBrick(0, brickList.get(0));
  }

  @Test
  @Transactional
  public void fetchByName() {
    assertBrick(0, brickRepository.fetchByUsername("habuma"));
    assertSpitter(1, spitterRepository.findByUsername("mwalls"));
    assertSpitter(2, spitterRepository.findByUsername("chuck"));
    assertSpitter(3, spitterRepository.findByUsername("artnames"));
  }

  @Test
  @Transactional
  public void findOne() {
    assertSpitter(0, spitterRepository.findOne(1L));
    assertSpitter(1, spitterRepository.findOne(2L));
    assertSpitter(2, spitterRepository.findOne(3L));
    assertSpitter(3, spitterRepository.findOne(4L));
  }

  @Test
  @Transactional
  public void save_newSpitter() {
    assertEquals(4, spitterRepository.count());
    Spitter spitter = new Spitter(null, "newbee", "letmein", "New Bee",
        "newbee@habuma.com", true);
    Spitter saved = spitterRepository.save(spitter);
    assertEquals(5, spitterRepository.count());
    assertSpitter(4, saved);
    assertSpitter(4, spitterRepository.findOne(5L));
  }

  @Test
  @Transactional
  public void save_existingSpitter() {
    assertEquals(4, spitterRepository.count());
    Spitter spitter = new Spitter(4L, "arthur", "letmein", "Arthur Names",
        "arthur@habuma.com", false);
    Spitter saved = spitterRepository.save(spitter);
    assertSpitter(5, saved);
    assertEquals(4, spitterRepository.count());
    Spitter updated = spitterRepository.findOne(4L);
    assertSpitter(5, updated);
  }

  private static void assertBrick(int expectedBrickIndex, Brick actual) {
    assertBrick(expectedBrickIndex, actual, "Newbie");
  }

  private static void assertBrick(int expectedBrickIndex, Brick actual,
      String expectedStatus) {
    Brick expected = BRICKARRAY[expectedBrickIndex];
    assertEquals(expected.getId(), actual.getId());
    assertEquals(expected.getElementCode(), actual.getElementCode());
    assertEquals(expected.getDesignCode(), actual.getDesignCode());
    assertEquals(expected.getName(), actual.getName());
    assertEquals(expected.getColorId(), actual.getColorId());
    assertEquals(expected.getCategoryId(), actual.getCategoryId());
    assertEquals(expected.getImageUrl(), actual.getImageUrl());
  }

  private static Brick[] BRICKARRAY = new Brick[1];

  @BeforeClass
  public static void before() {
    BRICKARRAY[0] = new Brick(1L, "1", "1", "brick", 1L, 1L, "url");
  }

}
