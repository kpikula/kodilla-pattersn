package com.kodilla.hibernate.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class Engine {
    private final List<Company> companies = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();

    @Autowired
    public Engine(List<Company> companies, List<Employee> employees) {
    }

    EntityManager em;

    @PersistenceContext
    public List findEmployee() {
        List employees = em.createNamedQuery("Employee.retrieveEmployeeWithLastNameFragment")
                .setParameter("LastNameFragment", "Ma")
                .getResultList();
        return employees;
    }

    public List findCompany() {
        List companies = em.createNamedQuery("Company.retrieveCompanyWithNameFragment")
                .setParameter("CompanyNameFragment", "Ma")
                .getResultList();
        return companies;
    }
}