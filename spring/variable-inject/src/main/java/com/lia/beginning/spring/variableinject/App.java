package com.lia.beginning.spring.variableinject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
   public static void main( String[] args )
   {

      Integer i = 1;
      //Brick obj = new Brick(i);
      //Set set = new Set(brick);
      
      ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
      Brick obj = (Brick) context.getBean("Brick");
      System.out.println(obj.getValue());
   }
}
