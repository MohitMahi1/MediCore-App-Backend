package com.mohit.MediCore.controller;

import com.mohit.MediCore.entities.Speciality;
import com.mohit.MediCore.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/specialities")
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @GetMapping
    public List<Speciality> getAll(){
        return specialityService.getAll();
    }
}
