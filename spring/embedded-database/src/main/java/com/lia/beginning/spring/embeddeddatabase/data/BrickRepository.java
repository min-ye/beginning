package com.lia.beginning.spring.embeddeddatabase.data;

import java.util.List;

import com.lia.beginning.spring.embeddeddatabase.model.Brick;

/**
 * Repository interface with operations for {@link Brick} persistence.
 * @author yemin
 */
public interface BrickRepository {

  long count();

  Brick save(Brick brick);

  Brick fetchById(long id);

  List<Brick> fetchByName(String name);

  List<Brick> fetchAll();

}
