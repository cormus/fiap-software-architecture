package com.cormus.architecture.app.domain.entity;

import com.cormus.architecture.app.domain.dto.ProdutoAtualizacaoDTO;
import com.cormus.architecture.app.domain.dto.ProdutoCadastroDTO;
import com.cormus.architecture.app.domain.dto.UsuarioAtualizacaoDto;
import com.cormus.architecture.app.domain.dto.UsuarioCadastroDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Table(name = "produto")
@Entity(name = "Produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_categoria")
    private Long idCategoria;

    private String nome;

    private Double valor;

    @Column(name = "data_exclusao")
    private LocalDateTime dataExclusao;

    public Produto(ProdutoCadastroDTO produto){

        this.nome = produto.nome();
        this.valor = produto.valor();

    }

    public Produto(ProdutoAtualizacaoDTO produto) {
        this.id = produto.id();
        this.nome = produto.nome();
        this.valor = produto.valor();
    }

    public Produto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
    }

    public void atualizar(ProdutoAtualizacaoDTO produtoDTO){
        this.nome = produtoDTO.nome();
        this.valor = produtoDTO.valor();
    }
}
