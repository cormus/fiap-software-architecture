package com.cormus.architecture.app.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClienteIdentificacaoDTO(
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf
) {
}
