package com.mohit.MediCore.entities;

import com.mohit.MediCore.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// This is for all user Details.

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//THis is for user Schima
@Document(collection = "users")
public class User {
//    All the user Details
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
//    The Enum UserRole is assgin to the roles
    private List<UserRole> roles;
    private Boolean isActive;
}
