package com.smartedu.course_service.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

  @GetMapping
  public List<Map<String, Object>> getCourses() {
    return List.of(
        Map.of("id", 1, "title", "Java Basics"),
        Map.of("id", 2, "title", "Spring Boot Fundamentals")
    );
  }
}

