package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static StudentRepository studentRepository;
    private StudentRepository() {}

    public static StudentRepository  getInstance() {
        if (studentRepository == null) {
            synchronized (StudentRepository.class) {
                if (studentRepository == null) {
                    studentRepository = new StudentRepository();
                }
            }
        }
        return studentRepository;
    }

    private final List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void add(Student student) {
        students.add(student);
    }

    public boolean updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    public Student findStudentById(int studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == studentId) {
                return students.get(i);
            }
        }
        return null;
    }
}
