package com.mohit.MediCore.repo;

import com.mohit.MediCore.entities.Speciality;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepo extends MongoRepository<Speciality, String> {
}
