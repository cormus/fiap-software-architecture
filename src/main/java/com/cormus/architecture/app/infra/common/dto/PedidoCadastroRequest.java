package com.cormus.architecture.app.infra.common.dto;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record PedidoCadastroRequest(


    Long idUsuario,

    @NotEmpty
    List<PedidoItemCadastroDTO> itens

) {

}
