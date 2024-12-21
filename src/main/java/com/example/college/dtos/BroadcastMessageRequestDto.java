package com.example.college.dtos;

import lombok.Data;

@Data
public class BroadcastMessageRequestDto {
    private String message;
    private long userId;
    private long batchId;
}
