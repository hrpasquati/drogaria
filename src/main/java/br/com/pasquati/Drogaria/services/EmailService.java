package br.com.pasquati.Drogaria.services;

import br.com.pasquati.Drogaria.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido pedido);

    void sendEmail(SimpleMailMessage simpleMailMessage);
}
