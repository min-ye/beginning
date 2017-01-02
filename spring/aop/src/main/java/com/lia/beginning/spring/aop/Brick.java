package com.lia.beginning.spring.aop;

public class Brick {
   private Integer id;
   private String code;

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getId() {
      return this.id;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getCode() {
      return this.code;
   }

   public void print() {
      System.out.println(String.format("[%d][%s]", this.id, this.code));
   }

   public void throwException() {
      throw new IllegalArgumentException();
   }
}