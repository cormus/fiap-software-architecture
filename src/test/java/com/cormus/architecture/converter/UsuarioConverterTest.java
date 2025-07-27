package com.cormus.architecture.converter;

import com.cormus.architecture.app.domain.entity.Usuario;
import com.cormus.architecture.app.infra.common.converter.UsuarioConverter;
import com.cormus.architecture.app.infra.persistence.jpa.entity.EnderecoVO;
import com.cormus.architecture.app.infra.persistence.jpa.entity.UsuarioEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class UsuarioConverterTest {

    @Test
    void deveConverterUsuarioEntityParaUsuario() {
        // Arrange
        EnderecoVO endereco = new EnderecoVO();
        endereco.setLogradouro("Rua A");
        endereco.setNumero("123");
        endereco.setBairro("Centro");
        endereco.setCidade("São Paulo");
        endereco.setUf("SP");
        endereco.setCep("01000-000");

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(1L);
        usuarioEntity.setNome("João da Silva");
        usuarioEntity.setTelefone("11999999999");
        usuarioEntity.setEmail("joao@email.com");
        usuarioEntity.setCpf("12345678900");
        usuarioEntity.setSenha("senha123");
        usuarioEntity.setEndereco(endereco);

        // Act
        Usuario usuario = UsuarioConverter.usuarioEntityParaUsuario(usuarioEntity);

        // Assert
        assertNotNull(usuario);
        assertEquals(1L, usuario.getId());
        assertEquals("João da Silva", usuario.getNome());
        assertEquals("11999999999", usuario.getTelefone());
        assertEquals("joao@email.com", usuario.getEmail());
        assertEquals("12345678900", usuario.getCpf());
        assertEquals("senha123", usuario.getSenha());
        assertNotNull(usuario.getEndereco());
        assertEquals("Rua A", usuario.getEndereco().getLogradouro());
        assertEquals("123", usuario.getEndereco().getNumero());
    }
}
