package com.lia.beginning.spring.xmlconfig;

public class CDPlayer implements MediaPlayer {
  private CompactDisc cd;

  public CDPlayer(CompactDisc cd) {
    this.cd = cd;
  }

  public void play() {
    cd.play();
  }

}
