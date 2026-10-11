package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.CourseEnrollmentStatus;
import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;

public class Enrollment {
    private final int id;
    private final int studentId;
    private final int courseId;
    private final LocalDate enrollmentDate;
    private CourseEnrollmentStatus courseEnrollmentStatus;

    public Enrollment(int studentId, int courseId, CourseEnrollmentStatus courseEnrollmentStatus) {
        this.id = IdGenerator.getNextEnrollmentId();
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = LocalDate.now();
        this.courseEnrollmentStatus = courseEnrollmentStatus;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public CourseEnrollmentStatus getCourseEnrollmentStatus() {
        return courseEnrollmentStatus;
    }

    public void setCourseEnrollmentStatus(CourseEnrollmentStatus courseEnrollmentStatus) {
        this.courseEnrollmentStatus = courseEnrollmentStatus;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Student ID: " + studentId
                + " | Course ID: " + courseId
                + " | Date: " + enrollmentDate
                + " | Status: " + courseEnrollmentStatus;
    }
}
