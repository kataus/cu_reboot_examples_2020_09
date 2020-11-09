package ru.sbrf.cu.solid;

public class SingleResponsibility {

    /*
        Пример нарушения принципа - в классе много разных несвяный методов
     */

  //Покормить кота
  public void feedCat(String food, Cat cat) {

  }

  //Склеить строки
  public void concatString(String st1, String st2) {

  }

  //Дебетовать счет
  public void debitAccount(double sum, String account) {

  }

  private class Cat {
  }
}
