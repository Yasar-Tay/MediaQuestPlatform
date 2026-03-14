package com.smartedu.course_service.controller;

import com.smartedu.course_service.model.Course;
import com.smartedu.course_service.service.CourseService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CourseGraphQLController {

  private final CourseService courseService;

  @QueryMapping
  public List<Course> courses() {
    return courseService.getAllCourses();
  }

  @QueryMapping
  public Course courseById(@Argument String id) {
    return courseService.getCourseById(id);
  }

  @MutationMapping
  public Course createCourse(
      @Argument String id,
      @Argument String title,
      @Argument String description
  ) {
    return courseService.createCourse(id, title, description);
  }

}
