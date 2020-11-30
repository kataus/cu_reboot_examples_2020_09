package ru.sbrf.cu.patterns.di;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import ru.sbrf.cu.patterns.di.parts.Engine;
import ru.sbrf.cu.patterns.di.parts.Transmission;

@RequiredArgsConstructor
@Getter
@ToString
public class Car {
    private final Engine engine;
    private final Transmission transmission;
}
