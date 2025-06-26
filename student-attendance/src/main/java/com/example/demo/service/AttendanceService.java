package com.example.demo.service;

import com.example.demo.entity.Attendance;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {
    private AttendanceRepository repo;

    public AttendanceService(AttendanceRepository repo){
        this.repo = repo;
    }

    public Attendance markAttendance(Attendance attendance) {
        return repo.save(attendance);
    }

    public Attendance getAttendanceById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance ID not found: " + id));
    }

    public List<Attendance> getAllAttendance() {
        return repo.findAll();
    }

    public Attendance updateAttendance(int id, Attendance updated) {
        Attendance existing = getAttendanceById(id);
        existing.setDate(updated.getDate());
        existing.setStatus(updated.getStatus());
        existing.setStudent(updated.getStudent());
        existing.setSubject(updated.getSubject());
        return repo.save(existing);
    }

    public Attendance deleteAttendance(int id) {
         Attendance attendance = repo.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Id was not Found" +id));
         repo.deleteById(id);
         return attendance;
    }
}
