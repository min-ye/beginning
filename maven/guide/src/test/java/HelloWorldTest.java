package com.lia.beginning.maven;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class HelloWorldTest {
   @Test
   public void testGetValue() {
      HelloWorld helloWorld = new HelloWorld();
      String result = helloWorld.getValue();
      assertEquals ("Hello Maven!", result);
   }
}