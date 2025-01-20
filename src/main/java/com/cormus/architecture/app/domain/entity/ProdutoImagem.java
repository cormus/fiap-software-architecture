package com.cormus.architecture.app.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "produto_imagem")
@Entity(name = "Produto imagem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProdutoImagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagem;

    @JsonBackReference
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_produto", referencedColumnName = "id", nullable = false)
    private Produto produto;
}
