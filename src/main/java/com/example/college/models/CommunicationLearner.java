package com.example.college.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class CommunicationLearner extends BaseModel{
    @ManyToOne
    public Learner learner;
    @ManyToOne
    private Communication communication;
    private boolean whatsappDelivered;
    private boolean emailDelivered;
}
