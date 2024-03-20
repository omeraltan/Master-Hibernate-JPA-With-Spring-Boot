package com.jpa.hibernate.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class PartTimeEmployee extends Employee{
    protected PartTimeEmployee(){}
    public PartTimeEmployee(String name, BigDecimal hourlyWage){
        super(name);
        this.hourlyWage = hourlyWage;
    }
    private BigDecimal hourlyWage;
}
