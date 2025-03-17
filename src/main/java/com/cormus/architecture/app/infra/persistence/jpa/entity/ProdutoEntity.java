package com.cormus.architecture.app.infra.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "produto")
@Entity(name = "Produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_categoria")
    private Long idCategoria;

    private String nome;

    private Double valor;

    @Column(name = "data_exclusao")
    private LocalDateTime dataExclusao;

    public void atualizar(ProdutoEntity produtoDTO){
        this.nome = produtoDTO.getNome();
        this.valor = produtoDTO.getValor();
    }
}
