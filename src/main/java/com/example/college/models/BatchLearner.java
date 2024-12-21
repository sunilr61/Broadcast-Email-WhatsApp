package com.example.college.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class BatchLearner extends BaseModel{
    @ManyToOne
    public Batch batch;
    @ManyToOne
    public Learner learner;
    public Date entryDate;
    public Date exitDate;
}
