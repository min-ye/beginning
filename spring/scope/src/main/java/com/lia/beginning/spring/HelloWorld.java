package com.lia.beginning.spring;

public class HelloWorld {
   private String message;
   private Integer index = 0;
   public void setMessage(String message) {
      this.message = message;
   }
    
   public void getMessage() {
      System.out.println("Your Message : " + message);
   }

   public void setIndex(Integer index) {
      this.index = index;
   }

   public Integer getIndex() {
      index ++;
      return index;
   }
}