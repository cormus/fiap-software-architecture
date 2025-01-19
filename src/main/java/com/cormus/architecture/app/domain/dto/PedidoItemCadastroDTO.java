package com.cormus.architecture.app.domain.dto;
import com.cormus.architecture.app.domain.entity.Produto;
import jakarta.validation.constraints.NotBlank;

public record PedidoItemCadastroDTO(
        @NotBlank
        int quantidade,

        @NotBlank
        Double valor,

        @NotBlank
        Produto produto
) {
}
