package ru.sbrf.cu.l02.animals;

public class Cat extends Mammal {
    @Override
    public void eat() {

    }

    @Override
    public void move() {

    }

    public void murrr(){

    }

    @Override
    public void meet(Mammal animal) {
        throw new RuntimeException("Fight");
//        super.meet(animal);
    }
}
