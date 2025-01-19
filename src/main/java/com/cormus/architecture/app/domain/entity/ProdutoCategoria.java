package com.cormus.architecture.app.domain.entity;

import com.cormus.architecture.app.domain.dto.ProdutoAtualizacaoDTO;
import com.cormus.architecture.app.domain.dto.ProdutoCadastroDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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
    private List<Produto> produtos;


}
