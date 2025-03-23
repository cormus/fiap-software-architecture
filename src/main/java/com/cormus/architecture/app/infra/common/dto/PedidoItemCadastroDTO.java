package com.cormus.architecture.app.infra.common.dto;
import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoEntity;
import jakarta.validation.constraints.NotBlank;

public record PedidoItemCadastroDTO(
        @NotBlank
        int quantidade,

        @NotBlank
        Double valor,

        @NotBlank
        ProdutoEntity produto
) {
}
