package com.mohit.MediCore.entities;
//This is for all doctors Details.
import lombok.*;
import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//THis is for doctor Schima
@Document(collection = "doctors")
public class Doctor {
    @Id
    private String id;
    private String name;
    private String email;
//    This @DBRef is relation between to entities,
//    means It will relationship between Doctors and specialities
    @DBRef
    @NonNull
    private Speciality speciality;
    private String phone;

//    means It will relationship between Doctors and users
    @DBRef
    @NonNull
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private String image;
    private float rating;
    private int consultationFee;
    private List<TimeSlots> availableSlots;

}
