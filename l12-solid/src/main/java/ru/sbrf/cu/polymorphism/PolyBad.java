package ru.sbrf.cu.polymorphism;

import ru.sbrf.cu.polymorphism.operations.Create;
import ru.sbrf.cu.polymorphism.operations.Update;


public class PolyBad {
  public static void main(String[] args) {
    new PolyBad().go("BAD1", "create");
    new PolyBad().go("BAD2", "update");
    // Как добавить select?
  }

  private void go(String data, String command) {
    switch (command) {
      case "create":
        new Create().action(data);
        break;
      case "update":
        new Update().action(data);
        break;
      default:
        throw new IllegalArgumentException("Unknown command:" + command);
    }
  }


}
