package com.example.college.dtos;

import com.example.college.models.Communication;
import lombok.Data;

@Data
public class BroadcastMessageResponseDto {

    private ResponseStatus status;
    private Communication communication;
}
