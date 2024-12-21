package com.example.college.adapters;

import com.example.college.library.sendgrid.Sendgrid;
import org.springframework.stereotype.Component;

@Component
public class SendgridWhatsappAdaper implements WhatsappAdapter{
    private final Sendgrid sendgrid = new Sendgrid();
    @Override
    public void sendWhatsappMessage(String phoneNumber, String message) throws Exception {
        sendgrid.sendWhatsApp(phoneNumber,message);
    }
}
