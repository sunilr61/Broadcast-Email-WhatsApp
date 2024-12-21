package com.example.college.services;

import com.example.college.exceptions.InvalidBatchException;
import com.example.college.exceptions.InvalidUserException;
import com.example.college.exceptions.UnAuthorizedAccessException;
import com.example.college.models.Communication;

public interface CommunicationService {

    public Communication broadcastMessage(long batchId, long userId, String message) throws InvalidBatchException, InvalidUserException, UnAuthorizedAccessException;
}
