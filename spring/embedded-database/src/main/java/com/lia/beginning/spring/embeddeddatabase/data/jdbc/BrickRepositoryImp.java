package com.lia.beginning.spring.embeddeddatabase.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.lia.beginning.spring.embeddeddatabase.model.Brick;
import com.lia.beginning.spring.embeddeddatabase.data.BrickRepository;

public class BrickRepositoryImp implements BrickRepository {

   private JdbcTemplate jdbcTemplate;

   public BrickRepositoryImp(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;      
   }

   public long count() {
      return jdbcTemplate.queryForObject("select count(Id) from Brick", Long.class);
   }

   public Brick save(Brick brick) {
      Long id = brick.getId();
      if (id == null) {
         long brickId = insertBrickAndReturnId(brick);
         return new Brick(brickId, brick.getElementCode(), brick.getDesignCode(), brick.getName(), brick.getColorId(), brick.getCategoryId(), brick.getImageUrl());
      } else {
         jdbcTemplate.update("update Brick set ElementCode=?, DesignCode=?, Name=?, ColorId=?, CategoryId=?, ImageUrl=? where Id=?",             
               brick.getElementCode(),
               brick.getDesignCode(),
               brick.getName(),
               brick.getColorId(),
               brick.getCategoryId(),
               brick.getImageUrl(),
               id);
      }
      return brick;
   }

   /**
    * Inserts a brick using SimpleJdbcInsert. 
    * Involves no direct SQL and is able to return the ID of the newly created Brick.
    * @param brick a Brick to insert into the database
    * @return the ID of the newly inserted Brick
    */
   private long insertBrickAndReturnId(Brick brick) {
      SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("Brick");
      jdbcInsert.setGeneratedKeyName("Id");
      Map<String, Object> args = new HashMap<String, Object>();
      args.put("ElementCode", brick.getElementCode());
      args.put("DesignCode", brick.getDesignCode());
      args.put("Name", brick.getName());
      args.put("ColorId", brick.getColorId());
      args.put("CategoryId", brick.getCategoryId());
      args.put("ImageUrl", brick.getImageUrl());
      long brickId = jdbcInsert.executeAndReturnKey(args).longValue();
      return brickId;
   }

   /**
    * Inserts a brick using a simple JdbcTemplate update() call.
    * Does not return the ID of the newly created Brick.
    * @param brick a Brick to insert into the database
    */
   @SuppressWarnings("unused")
   private void insertBrick(Brick brick) {
      jdbcTemplate.update(INSERT_BRICK, 
         brick.getElementCode(),
         brick.getDesignCode(),
         brick.getName(),
         brick.getColorId(),
         brick.getCategoryId(),
         brick.getImageUrl());
   }

  public Brick fetchById(long id) {
   return jdbcTemplate.queryForObject(
         SELECT_BRICK + " where id=?", new BrickRowMapper(), id);
  }

   public List<Brick> fetchByName(String name) {
      return jdbcTemplate.query("select Id, ElementCode, DesignCode, Name, ColorId, CategoryId, ImageUrl from Brick where Name=?", new BrickRowMapper(), name);
  }

   public List<Brick> fetchAll() {
      return jdbcTemplate.query("select Id, ElementCode DesignCode, Name, ColorId, CategoryId, ImageUrl from Brick order by Id", new BrickRowMapper());
   }

   private static final String INSERT_BRICK = "insert into Brick (ElemetCode, DesignCode, Name, ColorId, CategoryId, ImageUrl) values (?, ?, ?, ?, ?, ?)";

   private static final String SELECT_BRICK = "select Id, ElementCode, DesignCode, Name, ColorId, CategoryId, ImageUrl from Brick";

  
   private static class BrickRowMapper implements RowMapper<Brick> {
      public Brick mapRow(ResultSet rs, int rowNum) throws SQLException {
         return new Brick(
            rs.getLong("Id"),
            rs.getString("ElementCode"),
            rs.getString("DesignCode"),
            rs.getString("Name"),
            rs.getLong("ColorId"),
            rs.getLong("CategoryId"),
            rs.getString("ImageUrl"));
      }
   }

}
