package com.liu.spring.demo2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author lms
 * @date 2021-04-11 - 9:03
 */
public class Stu {
    private String[] courses;
    private List<String> grades;
    private Map<String, String> gg;

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    private List<Course> courseList;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setGrades(List<String> grades) {
        this.grades = grades;
    }

    public void setGg(Map<String, String> gg) {
        this.gg = gg;
    }


    public void show() {
        System.out.println("Arrays.toString(courses) = " + Arrays.toString(courses));
        System.out.println("grades = " + grades);
        System.out.println("gg = " + gg);
        System.out.println("courseList = " + courseList);
    }
}
