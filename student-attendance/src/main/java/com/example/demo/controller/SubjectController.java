package com.example.demo.controller;

import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    private SubjectService service;

    public SubjectController (SubjectService service) {
        this.service = service;
    }
        @PostMapping
        public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
            return new ResponseEntity<>(service.createSubject(subject), HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Subject> getSubjectById(@PathVariable int id) {
            return ResponseEntity.ok(service.getSubjectById(id));
        }

        @PutMapping("/{id}")
        public ResponseEntity<Subject> updateSubject(@PathVariable int id, @RequestBody Subject updated) {
            return ResponseEntity.ok(service.updateSubject(id, updated));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteSubject(@PathVariable int id) {
            service.deleteSubject(id);
            return ResponseEntity.noContent().build();
        }

        @GetMapping
        public ResponseEntity<List<Subject>> getAllSubjects() {
            return ResponseEntity.ok(service.getAllSubjects());
        }

}
