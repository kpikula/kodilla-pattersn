package com.kodilla.hibernate.manytomany.facade;

import org.springframework.stereotype.Component;

public class EmployeeDto {
    private final String lastName;

    public EmployeeDto(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
}
