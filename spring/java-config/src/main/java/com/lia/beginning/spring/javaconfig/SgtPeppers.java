package com.lia.beginning.spring.javaconfig;

//import org.springframework.stereotype.Component;

//@Component("lonelyHeart")
public class SgtPeppers implements CompactDisc {
   private String title = "Sgt. Pepper's Lonely Hearts Club Band";
   private String artist = "The Beatles";

   public void play(){
      System.out.println("Playing " + title + " by " + artist);
   }
}