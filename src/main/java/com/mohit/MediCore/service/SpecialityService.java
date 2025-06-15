package com.mohit.MediCore.service;

import com.mohit.MediCore.entities.Speciality;
import com.mohit.MediCore.repo.SpecialityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityService {

    @Autowired
    private SpecialityRepo specialityRepo;

    public List<Speciality> getAll(){
        return specialityRepo.findAll();
    }
}
