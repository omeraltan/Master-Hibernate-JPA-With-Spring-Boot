package com.jpa.hibernate.repository;

import com.jpa.hibernate.entity.*;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager em;

    //insert an employee
    public void insert(Employee employee){
        em.persist(employee);
    }
    //retrieve all employees
//    public List<Employee> retrieveAllEmployees(){
//        return em.createQuery("select e from Employee e", Employee.class).getResultList();
//    }
    public List<PartTimeEmployee> retrieveAllPartTimeEmployees(){
        return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
    }

    public List<FullTimeEmployee> retrieveAllFullTimeEmployees(){
        return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
    }

}
