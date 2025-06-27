package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student createStudent(Student student) {
        return repo.save(student);
    }

    public Student getStudentById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student ID not found: " + id));
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student updateStudent(int id, Student updatedStudent) {
        Student existing = getStudentById(id);
        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());
        existing.setRollNumber(updatedStudent.getRollNumber());
        return repo.save(existing);
    }

    public Student deleteStudent(int id) {
         Student student= repo.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Id was not Found" +id));
         repo.deleteById(id);
         return student;
    }
}
