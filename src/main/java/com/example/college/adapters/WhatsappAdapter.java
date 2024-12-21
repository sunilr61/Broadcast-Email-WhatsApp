package com.example.college.adapters;

import org.springframework.stereotype.Component;

@Component
public interface WhatsappAdapter {
    void sendWhatsappMessage(String phoneNumber, String message) throws Exception;
}
