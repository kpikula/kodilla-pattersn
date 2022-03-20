package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.Engine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchEngine {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyDto.class);
    private Engine engine;

    @Autowired
    public SearchEngine(Engine engine) {
        this.engine = engine;
    }

    public void find(Engine engine) throws ExceptionProcessing {
        boolean notFound = false;
        List<Company> companyList = engine.findCompany();
        List<Employee> employeeList = engine.findEmployee();
        try {
            if (employeeList.size() < 1 && companyList.size() < 1) {
                LOGGER.error(ExceptionProcessing.ERR_COMPANY_AND_EMPLOYEE_NOT_FOUND);
                notFound = true;
                throw new ExceptionProcessing(ExceptionProcessing.ERR_COMPANY_AND_EMPLOYEE_NOT_FOUND);
            }
            if (companyList.size() < 1 && employeeList.size() > 0) {
                LOGGER.error(ExceptionProcessing.ERR_COMPANY_NOT_FOUND);
                System.out.println(employeeList);
            }
            if (employeeList.size() < 1 && companyList.size() > 0) {
                LOGGER.error(ExceptionProcessing.ERR_EMPLOYEE_NOT_FOUND);
                System.out.println(companyList);
            } else {
                LOGGER.info("Search successful");
                System.out.println(companyList);
                System.out.println(employeeList);
            }
        } finally {
            if (notFound) {
                LOGGER.info("The search is over");
            }
        }
    }
}

