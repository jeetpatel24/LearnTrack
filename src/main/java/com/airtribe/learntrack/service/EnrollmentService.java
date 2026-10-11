package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.CourseEnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;

import java.util.List;

public class EnrollmentService {
    EnrollmentRepository enrollmentRepository =  EnrollmentRepository.getInstance();
    StudentRepository studentRepository =  StudentRepository.getInstance();
    CourseRepository courseRepository =  CourseRepository.getInstance();

    private boolean isStudentValid(Student student) throws EntityNotFoundException {
        Student validStudent = studentRepository.findStudentById(student.getId());
        if(validStudent == null) {
            throw new EntityNotFoundException("Student does not exist with id: " + student.getId());
        }
        return true;
    }

    private boolean isCourseValid(Course course) throws EntityNotFoundException {
        Course validCourse = courseRepository.findCourseById(course.getId());
        if(validCourse ==  null) {
            throw new EntityNotFoundException("Course does not exist with id: " + course.getId());
        }
        return true;
    }

    public Enrollment EnrollStudentToCourse(Student student, Course course) throws EntityNotFoundException {

        if(isStudentValid(student) && isCourseValid(course)) {
            return enrollmentRepository.enrollStudentToCourse(student, course);
        }
        return null;
    }

    public List<Enrollment> getEnrollmentsForStudent(Student student){
        return enrollmentRepository.getEnrollmentsForStudent(student);
    }

    public void markEnrollmentComplete(Student student, Course course) throws EntityNotFoundException {

        if(isStudentValid(student) && isCourseValid(course)) {
            Enrollment enrollment = enrollmentRepository.findEnrollment(student.getId(), course.getId());
            if (enrollment == null) {
                throw new EntityNotFoundException("No enrollment exists for student with ID: " + student.getId()
                        + " and course ID: " + course.getId());
            }
            enrollment.setCourseEnrollmentStatus(CourseEnrollmentStatus.COMPLETED);
        }
    }
}
