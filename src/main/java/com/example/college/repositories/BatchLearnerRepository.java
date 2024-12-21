package com.example.college.repositories;

import com.example.college.models.Batch;
import com.example.college.models.BatchLearner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BatchLearnerRepository extends JpaRepository<BatchLearner, Long> {
    List<BatchLearner> findByBatchIdAndExitDateIsNull(Long batchId);

}
