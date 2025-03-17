package com.cormus.architecture.app.infra.common.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AutenticacaoDto(
    @NotBlank
    String login,

    @NotBlank
    String senha
) {

}
