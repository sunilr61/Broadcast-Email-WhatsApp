package com.example.college.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="batches")
public class Batch extends BaseModel{

    private String name;
}
