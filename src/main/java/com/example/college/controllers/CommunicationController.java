package com.example.college.controllers;

import com.example.college.dtos.BroadcastMessageRequestDto;
import com.example.college.dtos.BroadcastMessageResponseDto;
import com.example.college.dtos.ResponseStatus;
import com.example.college.models.Communication;
import com.example.college.services.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CommunicationController {


    private final CommunicationService communicationService;

    @Autowired
    public CommunicationController(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }

    public BroadcastMessageResponseDto broadcastMessage(BroadcastMessageRequestDto requestDto) {
        BroadcastMessageResponseDto response = new BroadcastMessageResponseDto();
        try {
            Communication communication = communicationService.broadcastMessage(requestDto.getBatchId(), requestDto.getUserId(), requestDto.getMessage());
            response.setStatus(ResponseStatus.SUCCESS);
            response.setCommunication(communication);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
