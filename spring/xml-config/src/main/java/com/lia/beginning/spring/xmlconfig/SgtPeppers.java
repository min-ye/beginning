package com.lia.beginning.spring.xmlconfig;

public class SgtPeppers implements CompactDisc {
   private String title = "Sgt. Pepper's Lonely Hearts Club Band";
   private String artist = "The Beatles";

   public void play(){
      System.out.println("Playing " + title + " by " + artist);
   }
}