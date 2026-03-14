package com.smartedu.course_service.service;

import com.smartedu.course_service.model.Course;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

  private final List<Course> courses = new ArrayList<>();

  @PostConstruct
  public void init() {
    courses.add(new Course("1", "Java Basics", "Introduction to Java"));
    courses.add(new Course("2", "Spring Boot Fundamentals", "Basics of Spring Boot"));
  }

  public List<Course> getAllCourses() {
    return courses;
  }

  public Course getCourseById(String id) {
    return getAllCourses()
        .stream()
        .filter(course -> course.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  public Course createCourse(String id, String title, String description) {
    Course course = new Course(id, title, description);
    courses.add(course);
    return course;
  }
}

