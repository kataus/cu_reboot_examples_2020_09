package ru.sbrf.cu.patterns.di;

import ru.sbrf.cu.patterns.di.parts.L4Engine;
import ru.sbrf.cu.patterns.di.parts.RearDriveTransmission;

public class Runner {
    public static void main( String[] args ) {
        Car car = CarFactory.makeCar( new L4Engine(), new RearDriveTransmission() );
        System.out.println( car );

        // TODO сделать новую машину с мотором V6

        // TODO сделать новую машину с мотором V6 и полным приводом
    }
}
