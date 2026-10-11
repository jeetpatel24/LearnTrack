package com.airtribe.learntrack.util;

public class IdGenerator {
    private static int studentIdCounter = 0;
    private static int courseIdCounter = 0;
    private static int enrollmentIdCounter = 0;

    private IdGenerator() {}

    public static int getNextStudentId() {
        studentIdCounter = studentIdCounter + 1;
        return studentIdCounter;
    }

    public static int getNextCourseId() {
        courseIdCounter = courseIdCounter + 1;
        return courseIdCounter;
    }

    public static int getNextEnrollmentId() {
        enrollmentIdCounter = enrollmentIdCounter + 1;
        return enrollmentIdCounter;
    }
}
