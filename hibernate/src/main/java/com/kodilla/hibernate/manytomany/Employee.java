package com.kodilla.hibernate.manytomany;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "Employee.retrieveEmployeeWithLastName",
                query = "FROM Employee WHERE lastName = :LASTNAME"
        ),
        @NamedQuery(
                name = "Employee.retrieveEmployeeWithLastNameFragment",
                query = "FROM Employee WHERE lastName LIKE :LASTNAMEFRAGMENT"
        )}
)

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private List<Company> companies = new ArrayList<>();


    public Employee() {
    }

    public Employee(String firstname, String lastname) {
        this.firstName = firstname;
        this.lastName = lastname;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_COMPANY_EMPLOYEE",
            joinColumns = {@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")}
    )
    public List<Company> getCompanies() {
        return companies;
    }

    private void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "EMPLOYEE_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    @Column(name = "LASTNAME")
    public String getLastName() {
        return lastName;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    private void setLastName(String lastname) {
        this.lastName = lastname;
    }
}
