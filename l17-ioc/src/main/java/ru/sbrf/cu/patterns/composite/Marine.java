package ru.sbrf.cu.patterns.composite;

public class Marine implements Unit {
  @Override
  public void move() {
    System.out.println("Marine is moving");
  }
}
