package ru.sbrf.cu.lombok;

import lombok.Value;

import java.time.LocalDate;

@Value
public class Person {
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String address;
    String telephone;


}
