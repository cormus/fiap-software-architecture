package com.cormus.architecture.app.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoAtualizacaoDTO(

    @NotNull
    Long id,

    String nome,

    Double valor,

    Long idCategoria

) {



}
