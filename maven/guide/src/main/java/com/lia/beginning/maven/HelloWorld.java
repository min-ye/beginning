package com.lia.beginning.maven;

public class HelloWorld {
   public String getValue() {
      return "Hello Maven!";
   }

   public static void main(String[] args) {
      System.out.println(new HelloWorld().getValue());
   }
}
