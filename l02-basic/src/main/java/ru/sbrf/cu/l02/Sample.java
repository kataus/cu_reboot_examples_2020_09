package ru.sbrf.cu.l02;

public class Sample {
    private int valueInt;
    private final String valueStr = "start";

    public int getValue(){
        return valueInt;
    }

    public void setValue(int valueInt){
        this.valueInt = valueInt;
    }
}
