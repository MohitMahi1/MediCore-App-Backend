package com.mohit.MediCore.controller;

import com.mohit.MediCore.dto.DoctorDto;
import com.mohit.MediCore.entities.Doctor;
import com.mohit.MediCore.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//For creating REST APIs for all the doctors.
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

//    We inject the DoctorService dependent
    @Autowired
    private DoctorService doctorService;

//    We get the all the doctors
    @GetMapping
    public List<DoctorDto> getDoctors(){
       return doctorService.getAllDoctors();
    }

//    We create the doctors as using Post method
    @PostMapping
    public ResponseEntity<Doctor> create(Doctor doctor){
        return new ResponseEntity<>(doctorService.createDoctor(doctor), HttpStatus.CREATED);
    }

//    by the doctor ID we found the doctors
    @GetMapping("/{id}")
    public DoctorDto getDoctorsById(@PathVariable String id){
        return doctorService.getDoctorById(id);
    }
}
