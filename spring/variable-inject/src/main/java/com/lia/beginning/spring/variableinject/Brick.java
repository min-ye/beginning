package com.lia.beginning.spring.variableinject;

public class Brick {
   private Integer id;
   public Brick(Integer id) {
      this.id = id;
   }

   public String getValue(){
      return Integer.toString(this.id);
   }
}