package com.mohit.MediCore.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//THis is for Speciality Schima
@Document(collection = "specialities")
public class Speciality {
    @Id
    private String id;
    private String title;
    private String description;
}
