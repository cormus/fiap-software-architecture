package com.cormus.architecture;

import com.cormus.architecture.app.controller.ClienteRestController;
import com.cormus.architecture.app.domain.adapters.gateway.UsuarioGateway;
import com.cormus.architecture.app.domain.entity.Usuario;
import com.cormus.architecture.app.infra.common.dto.ClienteCadastroDTO;
import com.cormus.architecture.app.infra.common.dto.ClienteIdentificacaoDTO;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.UsuarioDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class ClienteRestControllerTest {

    @Mock
    UsuarioDataSource usuarioDataSource;

    @InjectMocks
    private UsuarioGateway usuarioGateway;

    @InjectMocks
    private ClienteRestController clienteRestController;

    @BeforeEach
    void setup() {
        Usuario usuario = new Usuario();
        usuario.setCpf("12345678901");
        usuario.setNome("Test User");
        usuario.setSenha("password");
        usuario.setEmail("teste@teste.com");
        usuario.setId(1L);
        when(usuarioDataSource.procurarPorCpf(anyString())).thenReturn(usuario);
        when(usuarioDataSource.cadastrar(any())).thenReturn(usuario);
    }

    @Test
    void testIdentificacao() {

        ClienteIdentificacaoDTO request = mock(ClienteIdentificacaoDTO.class);
        when(request.cpf()).thenReturn("12345678901");

        ResponseEntity response = clienteRestController.indentificacao(request);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    void testCadastrar() {

        ClienteCadastroDTO request = mock(ClienteCadastroDTO.class);
        when(request.nome()).thenReturn("Test User");
        when(request.email()).thenReturn("teste@teste.com");
        when(request.cpf()).thenReturn("12345678901");

        ResponseEntity response = clienteRestController.cadastrar(request);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }
}
