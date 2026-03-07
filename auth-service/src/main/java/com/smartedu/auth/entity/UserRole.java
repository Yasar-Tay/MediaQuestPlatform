package com.smartedu.auth.entity;

public enum UserRole {
  STUDENT("STUDENT"), TEACHER("TEACHER") , ADMIN("ADMIN"), ;
    private String value;
    UserRole(String value) {}
}
