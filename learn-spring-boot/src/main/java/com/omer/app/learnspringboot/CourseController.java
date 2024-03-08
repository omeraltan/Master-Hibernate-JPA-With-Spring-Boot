package com.omer.app.learnspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
            new Course(1L, "Learn AWS", "inJavaTrust"),
            new Course(2L, "Learn DevOps", "inJavaTrust"),
            new Course(3L, "Learn Azure", "inJavaTrust"),
            new Course(4L, "Learn GCP", "inJavaTrust")
        );
    }

}
