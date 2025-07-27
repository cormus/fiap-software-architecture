package com.cormus.architecture.entity;

import com.cormus.architecture.app.infra.common.dto.EnderecoDto;
import com.cormus.architecture.app.infra.common.dto.UsuarioAtualizacaoDto;
import com.cormus.architecture.app.infra.common.dto.UsuarioCadastroDto;
import com.cormus.architecture.app.infra.persistence.jpa.entity.UsuarioEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class UsuarioEntityTest {

    private UsuarioCadastroDto cadastroDto;
    private EnderecoDto enderecoDto;

    @BeforeEach
    void setUp() {
        enderecoDto = new EnderecoDto(
                "Rua das Flores", "123", "Apto 10", "Centro", "123456", "Cidade X", "SP"
        );

        cadastroDto = new UsuarioCadastroDto(
                "Maria Oliveira",
                "11988887777",
                "maria@email.com",
                "111.222.333-44",
                "senhaForte123",
                enderecoDto
        );
    }

    @Test
    void testConstrutorUsuarioCadastroDto() {
        UsuarioEntity usuario = new UsuarioEntity(cadastroDto);

        assertEquals("Maria Oliveira", usuario.getNome());
        assertEquals("11988887777", usuario.getTelefone());
        assertEquals("maria@email.com", usuario.getEmail());
        assertEquals("111.222.333-44", usuario.getCpf());
        assertEquals("senhaForte123", usuario.getSenha());

        assertNotNull(usuario.getEndereco());
        assertEquals("Cidade X", usuario.getEndereco().getCidade());
    }

    @Test
    void testAtualizacaoDeNome() {
        UsuarioEntity usuario = new UsuarioEntity(cadastroDto);

        UsuarioAtualizacaoDto atualizacao = new UsuarioAtualizacaoDto();
        atualizacao.setNome("Maria da Silva");

        usuario.atualizar(atualizacao);

        assertEquals("Maria da Silva", usuario.getNome());
    }

    @Test
    void testGetAuthorities() {
        UsuarioEntity usuario = new UsuarioEntity(cadastroDto);
        Collection<? extends GrantedAuthority> authorities = usuario.getAuthorities();

        assertEquals(1, authorities.size());
        assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Test
    void testGetUsernameAndPassword() {
        UsuarioEntity usuario = new UsuarioEntity(cadastroDto);

        assertEquals("maria@email.com", usuario.getUsername());
        assertEquals("senhaForte123", usuario.getPassword());
    }

    @Test
    void testSecurityFlags() {
        UsuarioEntity usuario = new UsuarioEntity(cadastroDto);

        assertTrue(usuario.isAccountNonExpired());
        assertTrue(usuario.isAccountNonLocked());
        assertTrue(usuario.isCredentialsNonExpired());
        assertTrue(usuario.isEnabled());
    }
}

