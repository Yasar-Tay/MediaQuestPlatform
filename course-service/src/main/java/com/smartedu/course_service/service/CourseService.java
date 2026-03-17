package com.smartedu.course_service.service;

import com.smartedu.course_service.dto.CreateCourseInput;
import com.smartedu.course_service.dto.UpdateCourseInput;
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

  public Course createCourse(CreateCourseInput input) {
    Course course = Course.builder()
        .id(input.getId())
        .title(input.getTitle())
        .description(input.getDescription())
        .build();
    courses.add(course);
    return course;
  }

  public Course updateCourse(UpdateCourseInput input) {
    Course course = getCourseById(input.getId());

    if (course == null) {
      return null;
    }

    if (input.getTitle() != null) {
      course.setTitle(input.getTitle());
    }

    if (input.getDescription() != null) {
      course.setDescription(input.getDescription());
    }

    return course;
  }

  public Course deleteCourse(String id) {
    Course course = getCourseById(id);
    if (course == null) {return null;}
    courses.remove(course);
    return course;
  }
}

