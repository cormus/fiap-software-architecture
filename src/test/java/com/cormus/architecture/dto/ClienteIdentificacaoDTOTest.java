package com.cormus.architecture.dto;

import com.cormus.architecture.app.infra.common.dto.ClienteIdentificacaoDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClienteIdentificacaoDTOTest {

    private static Validator validator;

    @BeforeAll
    static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testCpfValido() {
        ClienteIdentificacaoDTO dto = new ClienteIdentificacaoDTO("12345678901");
        Set<ConstraintViolation<ClienteIdentificacaoDTO>> violations = validator.validate(dto);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testCpfVazio() {
        ClienteIdentificacaoDTO dto = new ClienteIdentificacaoDTO("");
        Set<ConstraintViolation<ClienteIdentificacaoDTO>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testCpfNull() {
        ClienteIdentificacaoDTO dto = new ClienteIdentificacaoDTO(null);
        Set<ConstraintViolation<ClienteIdentificacaoDTO>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
    }
}
