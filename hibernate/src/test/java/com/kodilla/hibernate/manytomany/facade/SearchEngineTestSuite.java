package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Assertions;
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
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;


    @Test
    public void testSearchEngine() {
        //Given
        Employee johnMatison = new Employee("John", "Matison");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");


        employeeDao.save(johnMatison);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);

        //When

        List<Employee> employees = searchEngine.retrieveEmployee();
        List<Company> companies = searchEngine.retrieveCompany();

        //Then
        Assertions.assertEquals(1, employees.size());
        Assertions.assertEquals(1, companies.size());

        //Cleanup
        try {
            companyDao.deleteAll();
            employeeDao.deleteAll();
        } catch (Exception e) {
        }
    }
}