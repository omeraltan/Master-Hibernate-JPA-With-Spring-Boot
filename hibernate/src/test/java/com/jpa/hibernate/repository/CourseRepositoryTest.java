package com.jpa.hibernate.repository;

import com.jpa.hibernate.HibernateApplication;
import com.jpa.hibernate.entity.Course;
import com.jpa.hibernate.entity.Review;
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
public class CourseRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CourseRepository repository;
    @Autowired
    EntityManager em;
    @Test
    public void findById_basic(){
        Course course = repository.findById(10001L);
        assertEquals("JPA in 50 Steps", course.getName());
    }

    @Test
    @Transactional
    public void findById_firstLevelCacheDemo(){
        Course course = repository.findById(10001L);
        logger.info("First Course Retrieved {}", course);
        Course course1 = repository.findById(10001L);
        logger.info("First Course Retrieved again {}", course1);
        assertEquals("JPA in 50 Steps", course.getName());
        assertEquals("JPA in 50 Steps", course1.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById_basic(){
        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }

    @Test
    @DirtiesContext
    public void save_basic(){
        // get a courser
        Course course = repository.findById(10001L);
        assertEquals("JPA in 50 Steps", course.getName());
        // update details
        course.setName("JPA in 50 Steps - Updated");
        repository.save(course);
        // check the value
        Course course1 = repository.findById(10001L);
        assertEquals("JPA in 50 Steps - Updated", course1.getName());
    }

    @Test
    @DirtiesContext
    public void playWithEntityManager(){
        repository.playWithEntityManager();
    }

    @Test
    @Transactional
    public void retrieveReviewsForCourse(){
        Course course = repository.findById(10001L);
        logger.info("{}", course.getReviews());
    }

    @Test
    @Transactional
    public void retrieveCourseForReview(){
        Review review = em.find(Review.class, 50001L);
        logger.info("{}", review.getCourse());
    }

}
