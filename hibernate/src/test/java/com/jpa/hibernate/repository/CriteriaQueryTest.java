package com.jpa.hibernate.repository;

import com.jpa.hibernate.HibernateApplication;
import com.jpa.hibernate.entity.Course;
import com.jpa.hibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
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
public class CriteriaQueryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager em;
    @Test
    public void all_courses(){
        // "Select c From Course c"

        // 1. Use Criteria Builder to create a Criteria Query returning the expected result object.
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);
        // 3.Define Predicates etc using Criteria Builder
        // 4. Add Predicates etc to the Criteria Query
        // 5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }
    @Test
    public void all_courses_having_100Steps(){
        // "Select c From Course c Where name like '%100 Steps' "

        // 1. Use Criteria Builder to create a Criteria Query returning the expected result object.
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);
        // 3.Define Predicates etc using Criteria Builder
        Predicate like100Steps = cb.like(courseRoot.get("name"), "%100 Steps");
        // 4. Add Predicates etc to the Criteria Query
        cq.where(like100Steps);
        // 5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

    @Test
    public void all_courses_without_students(){
        // "Select c From Course c Where c.students is empty"

        // 1. Use Criteria Builder to create a Criteria Query returning the expected result object.
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);
        // 3.Define Predicates etc using Criteria Builder
        Predicate studentIsEmpty = cb.isEmpty(courseRoot.get("students"));
        // 4. Add Predicates etc to the Criteria Query
        cq.where(studentIsEmpty);
        // 5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

    @Test
    public void join(){
        // "Select c From Course c Join c.students s"

        // 1. Use Criteria Builder to create a Criteria Query returning the expected result object.
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);
        // 3.Define Predicates etc using Criteria Builder
        Join<Object, Object> join = courseRoot.join("students");
        // 4. Add Predicates etc to the Criteria Query

        // 5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

    @Test
    public void left_join(){
        // "Select c From Course c left join c.students s"

        // 1. Use Criteria Builder to create a Criteria Query returning the expected result object.
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        // 2. Define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);
        // 3.Define Predicates etc using Criteria Builder
        Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);
        // 4. Add Predicates etc to the Criteria Query

        // 5. Build the TypedQuery using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

}
