package com.example.demo.service;

import com.example.demo.entity.Subject;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private SubjectRepository repo;

    public SubjectService(SubjectRepository repo){
        this.repo = repo;
    }

    public Subject createSubject(Subject subject) {
        return repo.save(subject);
    }

    public Subject getSubjectById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject ID not found: " + id));
    }

    public List<Subject> getAllSubjects() {
        return repo.findAll();
    }

    public Subject updateSubject(int id, Subject updated) {
        Subject existing = getSubjectById(id);
        existing.setName(updated.getName());
        existing.setCode(updated.getCode());
        return repo.save(existing);
    }

    public void deleteSubject(int id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Subject ID not found: " + id);
        }
        repo.deleteById(id);
    }
}
