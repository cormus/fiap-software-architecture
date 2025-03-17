package com.cormus.architecture.app.infra.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "produto_categoria")
@Entity(name = "Produto Categoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProdutoCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_categoria")
    private List<ProdutoEntity> produtos;


}
