package com.cormus.architecture.app.infra.common.dto;
import jakarta.validation.constraints.NotBlank;

public record CheckoutItemDTO(
        @NotBlank
        int quantidade,

        @NotBlank
        Double valor,

        @NotBlank
        CheckoutProdutoDTO produto
) {
}