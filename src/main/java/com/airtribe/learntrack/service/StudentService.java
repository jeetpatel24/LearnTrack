package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;

import java.util.List;

public class StudentService {
    StudentRepository studentRepository = StudentRepository.getInstance();

    public void addStudent(Student student) {
        studentRepository.add(student);
    }

    public void removeStudent(int studentId) throws EntityNotFoundException {
        Student student = studentRepository.findStudentById(studentId);

        if(student == null) {
            throw new EntityNotFoundException("No student found with id: " + studentId);
        }

        student.setActive(false);
        studentRepository.updateStudent(student);
    }

    public Student updateStudent(Student student) throws EntityNotFoundException {
        if(!studentRepository.updateStudent(student)) {
            throw new EntityNotFoundException("No student not found with id: " + student.getId());
        }
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getStudents();
    }
}
