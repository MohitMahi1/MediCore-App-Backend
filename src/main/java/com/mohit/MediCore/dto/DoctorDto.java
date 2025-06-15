package com.mohit.MediCore.dto;

import com.mohit.MediCore.entities.Speciality;
import com.mohit.MediCore.entities.TimeSlots;
import com.mohit.MediCore.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorDto {

    private String id;
    private String name;
    private String email;
    private String speciality;
    private String phone;
    private String user;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private String image;
    private float rating;
    private int fee;
    private List<TimeSlots> availableSlots;
}
