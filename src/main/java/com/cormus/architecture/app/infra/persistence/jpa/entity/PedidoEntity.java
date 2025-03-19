package com.cormus.architecture.app.infra.persistence.jpa.entity;

import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "pedido")
@Entity(name = "Pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "pedido_data")
    private LocalDateTime pedidoData;

    @Enumerated(EnumType.STRING) // Configura como string no banco de dados
    @Column(name = "status", nullable = false)
    private PedidoStatusEnum status;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PedidoItemEntity> itens = new ArrayList<>();

    public PedidoEntity(PedidoEntity pedido) {
    }

    // Métodos auxiliares para manter a consistência da relação bidirecional
    public void addItem(PedidoItemEntity item) {
        item.setPedido(this); // Define o pedido para o item
        this.itens.add(item); // Adiciona o item à lista
    }

    public void removeItem(PedidoItemEntity item) {
        item.setPedido(null); // Remove a referência ao pedido
        this.itens.remove(item);
    }

}
