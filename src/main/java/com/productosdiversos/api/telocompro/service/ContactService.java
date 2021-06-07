package com.productosdiversos.api.telocompro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private JavaMailSender javaMailSender;

    private static final String RECEIVER = "rodolfo_fcb@outlook.com";
    private static final String SUBJECT = "Mensaje de ";

    public void sendEmail(String correo, String nombre, String mensaje) {
        var simpleMessage = new SimpleMailMessage();
        simpleMessage.setTo(RECEIVER);
        simpleMessage.setFrom(correo);
        simpleMessage.setSubject(SUBJECT.concat(nombre));
        simpleMessage.setText(mensaje);
        javaMailSender.send(simpleMessage);

    }

}
