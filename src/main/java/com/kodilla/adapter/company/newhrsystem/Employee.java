package com.kodilla.adapter.company.newhrsystem;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    final private String peselId;
    final private String firstname;
    final private String lastname;
    final private BigDecimal baseSalary;

    public Employee(String peselId, String firstName, String lastName, BigDecimal baseSalary) {
        this.peselId = peselId;
        this.firstname = firstName;
        this.lastname = lastName;
        this.baseSalary = baseSalary;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public String getPeselId() {
        return peselId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getPeselId().equals(employee.getPeselId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPeselId());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "peselId='" + peselId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
}
