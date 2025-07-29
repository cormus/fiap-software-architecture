package com.cormus.architecture.dto;

import com.cormus.architecture.app.infra.common.dto.PagamentoAtualizarStatusRequest;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoAtualizarStatusRequestTest {

    private static Validator validator;

    @BeforeAll
    static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void deveAceitarCamposValidos() {
        PagamentoAtualizarStatusRequest dto = new PagamentoAtualizarStatusRequest(1L, PagamentoStatusEnum.PAID);
        Set<ConstraintViolation<PagamentoAtualizarStatusRequest>> violations = validator.validate(dto);
        assertTrue(violations.isEmpty());
    }

    @Test
    void deveRejeitarIdPedidoNulo() {
        PagamentoAtualizarStatusRequest dto = new PagamentoAtualizarStatusRequest(null, PagamentoStatusEnum.PAID);
        Set<ConstraintViolation<PagamentoAtualizarStatusRequest>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
    }

    @Test
    void deveRejeitarStatusNulo() {
        PagamentoAtualizarStatusRequest dto = new PagamentoAtualizarStatusRequest(1L, null);
        Set<ConstraintViolation<PagamentoAtualizarStatusRequest>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
    }
}