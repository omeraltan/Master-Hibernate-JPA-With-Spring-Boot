package com.jpa.hibernate.repository;

import com.jpa.hibernate.entity.Course;
import com.jpa.hibernate.entity.Passport;
import com.jpa.hibernate.entity.Student;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager em;

    public Student findById(long id){
        return em.find(Student.class, id);
    }

    public Student save(Student student){
        if (student.getId() == null){
            em.persist(student);
        }else {
            em.merge(student);
        }
        return student;
    }

    public void deleteById(Long id){
        Student course = findById(id);
        em.remove(course);
    }

    public void saveStudentWithPassport(){
        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("Mike");
        student.setPassport(passport);
        em.persist(student);
    }

    public void someOperationToUnderstandPersistenceContext(){
        // Database Operation 1 - Retrieve student
        Student student = em.find(Student.class, 20001L);
        // Persistence Context (student)

        // Database Operation 2 - Retrieve passport
        Passport passport = student.getPassport();
        // Persistence Context (student, passport)

        // Database Operation 3 - update passport
        passport.setNumber("E123457");
        // Persistence Context (student, passport++)

        // Database Operation 4 - update student
        student.setName("Ranga - updated");
        // Persistence Context (student++, passport++)
    }

    public void insertStudentAndCourse(){
        Student student = new Student("Jack");
        Course course = new Course("Microservices in 100 Steps");
        em.persist(student);
        em.persist(course);

        student.addCourses(course);
        course.addStudent(student);
        em.persist(student);
    }

    public void insertStudentAndCourse(Student student, Course course){
        student.addCourses(course);
        course.addStudent(student);

        em.persist(student);
        em.persist(course);

        em.persist(student);
    }
}
