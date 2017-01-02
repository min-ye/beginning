package com.lia.beginning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class App {

   private static java.io.Console c = System.console();
   private static BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
   private static Boolean ide = false;
   
   public static void main(String[] args) throws IOException{
      AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
      obj.getMessage();
      String input;
      if (ide) {
         System.out.println("Press Enter to continue...");
         input = b.readLine();
      }
      else {
         input = c.readLine("Press Enter to continue...");
      }
      //context.registerShutdownHook();
      context.registerShutdownHook();
   }
}