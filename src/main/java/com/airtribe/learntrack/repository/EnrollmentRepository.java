package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.CourseEnrollmentStatus;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {

    private static EnrollmentRepository enrollmentRepository;
    private EnrollmentRepository() {}

    public static EnrollmentRepository  getInstance() {
        if (enrollmentRepository == null) {
            synchronized (EnrollmentRepository.class) {
                if (enrollmentRepository == null) {
                    enrollmentRepository = new EnrollmentRepository();
                }
            }
        }
        return enrollmentRepository;
    }

    private final List<Enrollment> enrollments = new ArrayList<>();

    public Enrollment enrollStudentToCourse(Student student, Course course){
        Enrollment enrollment = new Enrollment(student.getId(), course.getId(), CourseEnrollmentStatus.ACTIVE);
        enrollments.add(enrollment);
        return enrollment;
    }

    public List<Enrollment> getEnrollmentsForStudent(Student student){
        List<Enrollment> studentEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == student.getId()) {
                studentEnrollments.add(enrollment);
            }
        }
        return studentEnrollments;
    }

    public Enrollment findEnrollment(int studentId, int courseId) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId && enrollment.getCourseId() == courseId) {
                return enrollment;
            }
        }
        return null;
    }
}
