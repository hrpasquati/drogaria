package br.com.pasquati.Drogaria.services.validation;

import br.com.pasquati.Drogaria.domain.enums.TipoCliente;
import br.com.pasquati.Drogaria.dto.ClinteNewDTO;
import br.com.pasquati.Drogaria.resources.exception.FieldMessage;
import br.com.pasquati.Drogaria.services.validation.utils.BR;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ValidacaoDoCampoCpfOuCnpjValidator implements ConstraintValidator<ValidacaoDoCampoCpfOuCnpj, ClinteNewDTO> {
    @Override
    public void initialize(ValidacaoDoCampoCpfOuCnpj constraintAnnotation) {

    }

    @Override
    public boolean isValid(ClinteNewDTO clinteNewDTO, ConstraintValidatorContext constraintValidatorContext) {
        List<FieldMessage> fieldMessages = new ArrayList<>();

        if (clinteNewDTO.getTipo().equals(TipoCliente.PESSOAFISICA.getCododigoTipoCliente()) && !BR.isValidCPF(clinteNewDTO.getCpfOuCnpj())) {
            fieldMessages.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
        }

        if (clinteNewDTO.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCododigoTipoCliente()) && !BR.isValidCNPJ(clinteNewDTO.getCpfOuCnpj())) {
            fieldMessages.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
        }

        for (FieldMessage e : fieldMessages){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return fieldMessages.isEmpty();
    }
}
