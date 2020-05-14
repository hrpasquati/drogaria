package br.com.pasquati.Drogaria.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpEmailService extends AbstractEmailServer {

    private static final Logger log = LoggerFactory.getLogger(SmtpEmailService.class);

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendEmail(SimpleMailMessage simpleMailMessage) {
        log.info("Simulando envio de email");
        mailSender.send(simpleMailMessage);
        log.info("Email enviado");
    }
}
