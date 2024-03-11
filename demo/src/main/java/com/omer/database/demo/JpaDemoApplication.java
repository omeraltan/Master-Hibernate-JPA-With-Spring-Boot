package com.omer.database.demo;

import com.omer.database.demo.entity.Person;
import com.omer.database.demo.jdbc.PersonJdbcDAO;
import com.omer.database.demo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository repository;



    public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", repository.findById(10001));
        //logger.info("User id 10001 -> {}", repository.findById(10001));
        //logger.info("Deleting 10002 -> No of Row Deleted - {}", repository.deleteById(10002));
        logger.info("Inserting 10004 -> {}", repository.insert(new Person(10004, "Tara", "Berlin", new Date())));
        logger.info("Update 10003 -> {}", repository.update(new Person(10003, "Pieter", "Utrecht",new Date())));
        repository.deleteById(10002);
        logger.info("All users -> {}", repository.findAll());
    }
}
