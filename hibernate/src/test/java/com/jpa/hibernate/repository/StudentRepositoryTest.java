package com.jpa.hibernate.repository;

import com.jpa.hibernate.HibernateApplication;
import com.jpa.hibernate.entity.Address;
import com.jpa.hibernate.entity.Course;
import com.jpa.hibernate.entity.Passport;
import com.jpa.hibernate.entity.Student;
import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
public class StudentRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    StudentRepository repository;
    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void someTest(){
        repository.someOperationToUnderstandPersistenceContext();
    }
    @Test
    @Transactional
    public void setAddressDetails(){
        Student student = em.find(Student.class, 20001L);
        student.setAddress(new Address("No 101","Som Street", "Hyderabad"));
        em.flush();
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails(){
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent(){
        Passport passport = em.find(Passport.class, 40001L);
        logger.info("passport -> {}", passport);
        logger.info("student -> {}", passport.getStudent());
    }

    @Test
    @Transactional
    public void retrieveStudentAndCourses(){
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("courses -> {}", student.getCourses());
    }

}
