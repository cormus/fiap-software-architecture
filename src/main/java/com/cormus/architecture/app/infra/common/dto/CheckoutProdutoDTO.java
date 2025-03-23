package com.cormus.architecture.app.infra.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CheckoutProdutoDTO(
        @NotBlank
        Long id
) {
}
