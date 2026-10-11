package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;

import java.util.List;

public class CourseService {
    CourseRepository courseRepository =  CourseRepository.getInstance();

    public void addCourse(Course course) {
        courseRepository.add(course);
    }

    public void removeCourse(int courseId) throws EntityNotFoundException {
        Course course = courseRepository.findCourseById(courseId);
        if(course == null) {
            throw new EntityNotFoundException("No course found with id: " + courseId);
        }
        course.setActive(false);
        courseRepository.updateCourse(course);
    }

    public Course updateCourse(Course course) throws EntityNotFoundException {
        if(!courseRepository.updateCourse(course)) {
            throw new EntityNotFoundException("No course not found with id: " + course.getId());
        }
        return course;
    }

    public List<Course> getAllCourses() {
        return courseRepository.getCourses();
    }
}
