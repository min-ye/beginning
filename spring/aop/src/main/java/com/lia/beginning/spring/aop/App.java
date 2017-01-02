package com.lia.beginning.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
   public static void main( String[] args )
   {
      ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
      Brick brick = (Brick) context.getBean("brickProxy");
      brick.setId(1);
      brick.setCode("00001");
      brick.print();
      try {
         brick.throwException();
      }
      catch (Exception e) {
         System.out.println("App Throw Exception.");
      }
   }
}
