package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<com.kodilla.hibernate.manytomany.Employee, Integer> {

    List<Employee> findEmployeeByLastName(String lastName);

    @Query
    List<Employee> retrieveEmployeeWithLastName(@Param("LASTNAME") String lastName);

    @Query
    List<Employee> retrieveEmployeeWithLastNameFragment(@Param("LASTNAMEFRAGMENT") String lastNameFragment);
}
