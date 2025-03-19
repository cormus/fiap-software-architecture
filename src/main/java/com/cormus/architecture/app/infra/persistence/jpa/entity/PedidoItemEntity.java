package com.cormus.architecture.app.infra.persistence.jpa.entity;

import com.cormus.architecture.app.infra.common.dto.PedidoItemCadastroDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "pedido_item")
@Entity(name = "Pedido Item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PedidoItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidade;

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    @JsonBackReference
    private PedidoEntity pedido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produto", nullable = false)
    private ProdutoEntity produto;

    public PedidoItemEntity(PedidoItemCadastroDTO item) {
        this.quantidade = item.quantidade();
        this.valor = item.valor();
        this.produto = item.produto();
    }
}
