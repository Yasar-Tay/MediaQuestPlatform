package com.smartedu.course_service.dto;

import lombok.Data;

@Data
public class UpdateCourseInput {
  private String id;
  private String title;
  private String description;
}
