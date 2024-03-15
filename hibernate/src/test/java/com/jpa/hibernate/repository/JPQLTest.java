package com.jpa.hibernate.repository;

import com.jpa.hibernate.HibernateApplication;
import com.jpa.hibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager em;
    @Test
    public void jpql_basic(){
        List resultList = em.createNamedQuery("query_get_all_courses").getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    public void jpql_typed(){
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
        List resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    public void jpql_where(){
        TypedQuery<Course> query = em.createNamedQuery("query_get_100_Step_courses", Course.class);
        List resultList = query.getResultList();
        logger.info("Select c From Course c where name like '%100 Steps -> {}", resultList);
    }
}
