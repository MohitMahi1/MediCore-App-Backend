package com.mohit.MediCore.controller;

import com.mohit.MediCore.dto.DoctorDto;
import com.mohit.MediCore.entities.Doctor;
import com.mohit.MediCore.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<DoctorDto> getDoctors(){
       return doctorService.getAllDoctors();
    }

    public ResponseEntity<Doctor> create(Doctor doctor){
        return new ResponseEntity<>(doctorService.createDoctor(doctor), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public DoctorDto getDoctorsById(@PathVariable String id){
        return doctorService.getDoctorById(id);
    }
}
