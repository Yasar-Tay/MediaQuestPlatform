package com.smartedu.course_service.controller;

import com.smartedu.course_service.dto.CreateCourseInput;
import com.smartedu.course_service.dto.UpdateCourseInput;
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
      @Argument CreateCourseInput input
  ) {
    return courseService.createCourse(input);
  }

  @MutationMapping
  public Course updateCourse(@Argument UpdateCourseInput input){
    return courseService.updateCourse(input);
  }

  @MutationMapping
  public Course deleteCourse(@Argument String id){
    return courseService.deleteCourse(id);
  }

}
