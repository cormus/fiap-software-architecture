package com.cormus.architecture.dto;

import com.cormus.architecture.app.infra.common.dto.AutenticacaoDto;
import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AutenticacaoDtoTest {

    private Validator validator;

    @BeforeEach
    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void deveValidarCamposPreenchidos() {
        AutenticacaoDto dto = new AutenticacaoDto("usuario", "senha123");
        Set<ConstraintViolation<AutenticacaoDto>> violations = validator.validate(dto);
        assertTrue(violations.isEmpty(), "Não deveria haver violações de validação");
    }

    @Test
    void deveDetectarLoginVazio() {
        AutenticacaoDto dto = new AutenticacaoDto("", "senha123");
        Set<ConstraintViolation<AutenticacaoDto>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("login")));
    }

    @Test
    void deveDetectarSenhaVazia() {
        AutenticacaoDto dto = new AutenticacaoDto("usuario", "");
        Set<ConstraintViolation<AutenticacaoDto>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("senha")));
    }

    @Test
    void deveDetectarLoginNulo() {
        AutenticacaoDto dto = new AutenticacaoDto(null, "senha123");
        Set<ConstraintViolation<AutenticacaoDto>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("login")));
    }

    @Test
    void deveDetectarSenhaNula() {
        AutenticacaoDto dto = new AutenticacaoDto("usuario", null);
        Set<ConstraintViolation<AutenticacaoDto>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("senha")));
    }
}