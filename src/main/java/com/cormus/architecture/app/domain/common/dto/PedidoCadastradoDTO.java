package com.cormus.architecture.app.domain.common.dto;

import com.cormus.architecture.app.domain.entity.PedidoItem;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PedidoCadastradoDTO {

    private Long id;

    private Long idUsuario;

    private LocalDateTime pedidoData;

    private PedidoStatusEnum status;

    private List<PedidoItemCadastradoDTO> itens = new ArrayList<>();

}
