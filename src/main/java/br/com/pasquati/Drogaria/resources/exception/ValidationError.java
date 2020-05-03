package br.com.pasquati.Drogaria.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandartError {

    List<FieldMessage> fieldMessages = new ArrayList<>();

    public ValidationError(Integer statusHttp, String mensagem, Long timeStamp) {
        super(statusHttp, mensagem, timeStamp);
    }

    public List<FieldMessage> getError() {
        return fieldMessages;
    }

    public void addError(String fieldName, String message) {
        fieldMessages.add(new FieldMessage(fieldName, message));
    }
}
