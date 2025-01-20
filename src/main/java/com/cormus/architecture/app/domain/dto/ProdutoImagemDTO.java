package com.cormus.architecture.app.domain.dto;

import jakarta.validation.constraints.NotNull;

public record ProdutoImagemDTO(
        @NotNull
        String imagem
) {
}
