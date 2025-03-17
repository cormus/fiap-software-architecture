package com.cormus.architecture.app.infra.persistence.jpa.entity;

import com.cormus.architecture.app.infra.common.dto.UsuarioAtualizacaoDto;
import com.cormus.architecture.app.infra.common.dto.UsuarioCadastroDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuario")
@Entity(name = "Usuário")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario  implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String senha;

    @Embedded
    private Endereco endereco;

    public Usuario(UsuarioCadastroDto usuario) {
        this.nome = usuario.nome();
        this.telefone = usuario.telefone();
        this.email = usuario.email();
        this.cpf = usuario.cpf();
        this.senha = usuario.senha();
        this.endereco = new Endereco(usuario.endereco());
    }

    public void atualizar(UsuarioAtualizacaoDto usuario){
        this.nome = usuario.getNome();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
