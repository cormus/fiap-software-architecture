package com.cormus.architecture.app.domain.entity;

import com.cormus.architecture.app.domain.dto.PedidoItemCadastroDTO;
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
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidade;

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    @JsonBackReference
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    public PedidoItem(PedidoItemCadastroDTO item) {
        this.quantidade = item.quantidade();
        this.valor = item.valor();
        this.produto = item.produto();
    }
}
