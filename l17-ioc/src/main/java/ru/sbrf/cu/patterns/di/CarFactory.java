package ru.sbrf.cu.patterns.di;

import ru.sbrf.cu.patterns.di.parts.Engine;
import ru.sbrf.cu.patterns.di.parts.Transmission;

public class CarFactory {
    public static Car makeCar( Engine engine, Transmission transmission ) {
        return new Car( engine, transmission );
    }
}
