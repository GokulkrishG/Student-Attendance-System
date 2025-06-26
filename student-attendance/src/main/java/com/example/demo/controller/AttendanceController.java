package com.example.demo.controller;

import com.example.demo.entity.Attendance;
import com.example.demo.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    private AttendanceService service;

    public AttendanceController(AttendanceService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Attendance> markAttendance(@RequestBody Attendance attendance) {
        return new ResponseEntity<>(service.markAttendance(attendance), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable int id) {
        return ResponseEntity.ok(service.getAttendanceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable int id, @RequestBody Attendance updated) {
        return ResponseEntity.ok(service.updateAttendance(id, updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable int id) {
        service.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendance() {
        return ResponseEntity.ok(service.getAllAttendance());
    }
}
