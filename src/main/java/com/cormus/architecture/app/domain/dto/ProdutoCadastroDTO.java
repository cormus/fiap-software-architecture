package com.cormus.architecture.app.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoCadastroDTO(

        @NotBlank
        String nome,

        @NotNull
        Double valor

) {



}
