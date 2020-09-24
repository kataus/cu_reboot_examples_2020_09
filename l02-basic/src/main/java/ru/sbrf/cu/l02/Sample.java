package ru.sbrf.cu.l02;

public class Sample {
    private int valueInt;
    private final String valueStr = "start";

    public int getValue() {
        // Простой строчный комментарий
        return valueInt; // Он же
    }

    /**
     * JavaDoc комментарий
     * @param valueInt
     */
    public void setValue( int valueInt ) {
        /*
        * Комментарий состоящий из блока
        * */
        this.valueInt = valueInt;
    }
}
