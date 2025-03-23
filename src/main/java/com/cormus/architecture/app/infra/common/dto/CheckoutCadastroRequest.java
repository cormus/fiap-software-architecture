package com.cormus.architecture.app.infra.common.dto;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;


import java.util.List;

public record CheckoutCadastroRequest(
        Long idUsuario,

        @NotEmpty
        List<CheckoutItemDTO> itens
) {

}
