package com.jpa.hibernate.repository;

import com.jpa.hibernate.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

}
