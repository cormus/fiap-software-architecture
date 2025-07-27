package com.cormus.architecture.datasource;

import com.cormus.architecture.app.domain.entity.Usuario;
import com.cormus.architecture.app.infra.common.converter.UsuarioConverter;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.UsuarioDataSource;
import com.cormus.architecture.app.infra.persistence.jpa.entity.UsuarioEntity;
import com.cormus.architecture.app.infra.persistence.jpa.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioDataSourceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Spy
    private UsuarioConverter usuarioConverter; // Use @Spy if UsuarioConverter has static methods, otherwise mock as needed

    @InjectMocks
    private UsuarioDataSource usuarioDataSource;

    @Test
    void testProcurarPorCpf_found() {
        String cpf = "12345678900";
        UsuarioEntity entity = new UsuarioEntity();
        entity.setCpf(cpf);
        entity.setNome("Nome");
        entity.setEmail("email@teste.com");

        when(usuarioRepository.findByCpf(cpf)).thenReturn(entity);

        Usuario usuario = usuarioDataSource.procurarPorCpf(cpf);

        assertNotNull(usuario);
        assertEquals(cpf, usuario.getCpf());
    }

    @Test
    void testProcurarPorCpf_notFound() {
        String cpf = "00000000000";
        when(usuarioRepository.findByCpf(cpf)).thenReturn(null);

        Usuario usuario = usuarioDataSource.procurarPorCpf(cpf);

        assertNull(usuario);
    }

    @Test
    void testCadastrar() {
        Usuario usuario = new Usuario();
        usuario.setNome("Nome");
        usuario.setEmail("email@teste.com");
        usuario.setCpf("12345678900");

        // Simula o comportamento do save
        when(usuarioRepository.save(any(UsuarioEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Usuario result = usuarioDataSource.cadastrar(usuario);

        assertNotNull(result);
        assertEquals(usuario.getCpf(), result.getCpf());
        verify(usuarioRepository, times(1)).save(any(UsuarioEntity.class));
    }

    @Test
    void testProcurarPorId_found() {
        Long id = 1L;
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(id);
        entity.setCpf("12345678900");
        entity.setNome("Nome");
        entity.setEmail("email@teste.com");

        when(usuarioRepository.getReferenceById(id)).thenReturn(entity);

        Usuario usuario = usuarioDataSource.procurarPorId(id);

        assertNotNull(usuario);
        assertEquals(id, usuario.getId());
    }

    @Test
    void testProcurarPorId_notFound() {
        Long id = 2L;
        when(usuarioRepository.getReferenceById(id)).thenReturn(null);

        Usuario usuario = usuarioDataSource.procurarPorId(id);

        assertNull(usuario);
    }
}