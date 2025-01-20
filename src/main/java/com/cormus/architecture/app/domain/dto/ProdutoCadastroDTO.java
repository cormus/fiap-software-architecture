package com.cormus.architecture.app.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ProdutoCadastroDTO(

        @NotBlank
        String nome,

        @NotNull
        Double valor,

        @NotNull
        Long idCategoria,

        List<ProdutoImagemDTO> imagens

) {



}
