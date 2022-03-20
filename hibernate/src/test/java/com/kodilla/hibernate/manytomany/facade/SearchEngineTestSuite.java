package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.Engine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SearchEngineTestSuite {
    @Autowired
    private SearchEngine searchEngine;

    @Autowired
    private Engine engine;

    @Test
    public void testSearchEngine() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        List<Employee> employees = new ArrayList<>();
        employees.add(johnSmith);
        employees.add(stephanieClarckson);
        employees.add(lindaKovalsky);

        List<Company> companies = new ArrayList<>();
        companies.add(softwareMachine);
        companies.add(dataMaesters);
        companies.add(greyMatter);

        //When
        Engine engine = new Engine(companies, employees);

        //Then
        try {
            searchEngine.find(engine);
        } catch (ExceptionProcessing e) {
        }
    }
}