package br.com.pasquati.Drogaria.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;



public class MockEmailService extends AbstractEmailServer {

    private static final Logger log = LoggerFactory.getLogger(MockEmailService.class);
    @Override
    public void sendEmail(SimpleMailMessage simpleMailMessage) {
        log.info("Simulando envio de email");
        log.info(simpleMailMessage.toString());
        log.info("Email enviado");
    }
}
