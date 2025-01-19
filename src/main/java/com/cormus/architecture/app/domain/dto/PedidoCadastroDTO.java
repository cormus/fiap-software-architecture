package com.cormus.architecture.app.domain.dto;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record PedidoCadastroDTO(


    Long idUsuario,

    @NotEmpty
    List<PedidoItemCadastroDTO> itens

) {

}
