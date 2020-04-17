package br.com.pasquati.Drogaria.services.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String message) { //Contrutor responsavel pela criação da mensagem
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) { //Construtor sobrecarregado, causa de uma coisa que aconteceu antes.
        super(message, cause);
    }
}
