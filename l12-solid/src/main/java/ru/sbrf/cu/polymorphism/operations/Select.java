package ru.sbrf.cu.polymorphism.operations;

import ru.sbrf.cu.polymorphism.Operation;

public class Select implements Operation {
  @Override
  public void action(String data) {
    System.out.println("select, data:" + data);
  }
}
