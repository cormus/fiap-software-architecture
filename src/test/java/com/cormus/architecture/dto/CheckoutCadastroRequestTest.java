package com.cormus.architecture.dto;

import com.cormus.architecture.app.infra.common.dto.CheckoutCadastroRequest;
import com.cormus.architecture.app.infra.common.dto.CheckoutItemDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckoutCadastroRequestTest {

    private static Validator validator;

    @BeforeAll
    static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void deveRejeitarListaVazia() {
        CheckoutCadastroRequest dto = new CheckoutCadastroRequest(1L, List.of());
        Set<ConstraintViolation<CheckoutCadastroRequest>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
    }

    @Test
    void deveRejeitarListaNula() {
        CheckoutCadastroRequest dto = new CheckoutCadastroRequest(1L, null);
        Set<ConstraintViolation<CheckoutCadastroRequest>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
    }
}