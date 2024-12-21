package com.example.college.repositories;

import com.example.college.models.CommunicationLearner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationLearnerRepository extends JpaRepository<CommunicationLearner, Long> {
}
