package com.lia.beginning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      HelloWorld obj1 = (HelloWorld) context.getBean("helloWorld");
      Integer value1 = obj1.getIndex();
      System.out.println(String.format("%d", value1));
      HelloWorld obj2 = (HelloWorld) context.getBean("helloWorld");
      Integer value2 = obj2.getIndex();
      System.out.println(String.format("%d", value2));
   }
}