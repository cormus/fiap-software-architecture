package com.cormus.architecture.app.domain.common.dto;

import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PedidoCadastroDTO {

    private Long idUsuario;

    private PedidoStatusEnum status;

    private List<PedidoItemCadastroDTO> itens = new ArrayList<>();

}
