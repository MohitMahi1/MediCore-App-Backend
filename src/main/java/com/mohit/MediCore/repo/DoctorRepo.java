package com.mohit.MediCore.repo;

import com.mohit.MediCore.entities.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends MongoRepository<Doctor, String> {
}
