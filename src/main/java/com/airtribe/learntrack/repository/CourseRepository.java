package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private static CourseRepository courseRepository;
    private CourseRepository() {}

    public static CourseRepository getInstance() {
        if(courseRepository == null) {
            synchronized (CourseRepository.class) {
                if(courseRepository == null) {
                    courseRepository = new CourseRepository();
                }
            }
        }
        return courseRepository;
    }

    private final List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public void add(Course course) {
        courses.add(course);
    }

    public boolean updateCourse(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == course.getId()) {
                courses.set(i, course);
                return true;
            }
        }
        return false;
    }

    public Course findCourseById(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                return courses.get(i);
            }
        }
        return null;
    }
}
