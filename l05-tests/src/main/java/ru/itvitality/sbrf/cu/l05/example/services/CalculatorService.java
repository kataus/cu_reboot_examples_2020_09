package ru.itvitality.sbrf.cu.l05.example.services;

public interface CalculatorService {
    void readTwoDigitsAndMultiply();

    void readTwoDigitsAndMultiply( String prompt );

    void multiplyTwoDigits( String prompt, int d1, int d2 );

    void longCalculations();
}
