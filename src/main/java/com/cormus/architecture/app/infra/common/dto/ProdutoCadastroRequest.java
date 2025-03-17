package com.cormus.architecture.app.infra.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoCadastroRequest(

        @NotNull
        Long idCategoria,

        @NotBlank
        String nome,

        @NotNull
        Double valor

) {



}
