package com.mohit.MediCore.service;

// This is the Doctor service class which is used in Controller.
import com.mohit.MediCore.dto.DoctorDto;
import com.mohit.MediCore.entities.Doctor;
import com.mohit.MediCore.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

//    We inject the Dependencies of DoctorRepo.
    @Autowired
    private DoctorRepo doctorRepo;

    // This method for get all the doctors,
    // If there are n number of Doctors then It will show all the n number doctors.
    public List<DoctorDto> getAllDoctors(){
//        We get all the data by the List of Doctors then I returned it
        List<Doctor> doctors = doctorRepo.findAll();
        return doctors.stream().map(doctor -> DoctorDto.builder()
                    .email(doctor.getEmail())
                    .name(doctor.getName())
                    .id(doctor.getId())
                    .phone(doctor.getPhone())
                    .availableSlots(doctor.getAvailableSlots())
                    .image(doctor.getImage())
                    .fee(doctor.getConsultationFee())
                    .user(doctor.getUser().getId())
                    .rating(doctor.getRating())
                    .speciality(doctor.getSpeciality().getId())
                    .build()).collect(Collectors.toList());
    }


    public Doctor createDoctor(Doctor doctor){
        return doctorRepo.save(doctor);
    }

    public DoctorDto getDoctorById(String doctorId){
        return doctorRepo.findById(doctorId).map(doctor -> DoctorDto.builder()
                        .email(doctor.getEmail())
                        .name(doctor.getName())
                        .id(doctor.getId())
                        .phone(doctor.getPhone())
                        .availableSlots(doctor.getAvailableSlots())
                        .image(doctor.getImage())
                        .fee(doctor.getConsultationFee())
                        .user(doctor.getUser().getId())
                        .rating(doctor.getRating())
                        .speciality(doctor.getSpeciality().getId()).build())
                .orElseThrow(()-> new RuntimeException("Doctor Not Found !"));
    }
}
