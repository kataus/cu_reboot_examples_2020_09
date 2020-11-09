package ru.sbrf.cu.polymorphism.operations;

import ru.sbrf.cu.polymorphism.Operation;

public class Update implements Operation {
  @Override
  public void action(String data) {
    System.out.println("update, data:" + data);
  }
}
