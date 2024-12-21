package com.example.college.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Communication extends BaseModel{
    @ManyToOne
    private Batch batch;
    private String message;
    @ManyToOne
    private User sentBy;
}
