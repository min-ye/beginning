package com.lia.beginning.spring.aop;

import java.util.Arrays;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class BrickAroundMethod implements MethodInterceptor {
   @Override
   public Object invoke(MethodInvocation methodInvocation) throws Throwable {
      System.out.println("Method name: "
            + methodInvocation.getMethod().getName());
      System.out.println("Method arguments: "
            + Arrays.toString(methodInvocation.getArguments()));

      System.out.println("BrickAroundMethod: Before method Brick!");

      try {
         // proceed to original method call
         Object result = methodInvocation.proceed();

         // same with AfterReturningAdvice
         System.out.println("BrickAroundMethod: Before after Brick!");

         return result;

      } catch (IllegalArgumentException e) {
         // same with ThrowsAdvice
         System.out.println("BrickAroundMethod: Throw exception Brick!");
         throw e;
      }
   }
}