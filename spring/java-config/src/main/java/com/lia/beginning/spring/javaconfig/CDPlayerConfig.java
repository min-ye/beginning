package com.lia.beginning.spring.javaconfig;

//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//@ComponentScan
public class CDPlayerConfig {
   @Bean
  public CompactDisc CompactDisc() {
    return new SgtPeppers();
  }
  
  @Bean
  public CDPlayer CDPlayer(CompactDisc compactDisc) {
    return new CDPlayer(compactDisc);
  }
}