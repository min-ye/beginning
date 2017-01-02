package com.lia.beginning.spring.aop;

import org.springframework.aop.ThrowsAdvice;

public class BrickThrowException implements ThrowsAdvice {
   public void afterThrowing(IllegalArgumentException e) throws Throwable {
      System.out.println("Brick Throw Exception!");
   }
}