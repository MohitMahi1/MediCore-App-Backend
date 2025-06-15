package com.mohit.MediCore.entities;

// This is for all Appointment Details.

import com.mohit.MediCore.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

// Using the lombok for the clean and easy code means It gets all getter and setter etc
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// It is a MonogoDB Annot.
@Document(collection = "appointments")
public class Appointment {

    // All Appointment Details
    @Id
    private String id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private AppointmentStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    @DBRef
    private User user;
    @DBRef
    private Doctor doctor;
    @DBRef
    private Patient patient;


}
