package com.lia.beginning.spring.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

//import com.lia.beginning.spring.autowiring.CDPlayer;
//import com.lia.beginning.spring.autowiring.SgtPeppers;

public class App 
{
   //@Autowired
   //private MediaPlayer player;

   public static void main( String[] args )
   {
      //SgtPeppers cd = new SgtPeppers();
      //CDPlayer player = new CDPlayer(cd);

      ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
      CDPlayer player = (CDPlayer) context.getBean("CDPlayer");
      player.play();
      //player.play();
   }
}
