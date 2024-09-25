package org.example.service;

import org.example.interfaces.UsuarioRepository;
import org.example.domain.Usuario;

import java.util.List;


public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioRepository UsuarioRepository;

    public void UsuarioRepository(UsuarioRepository usuarioRepository) {
        this.UsuarioRepository = usuarioRepository;
    }

    public UsuarioServiceImpl(org.example.interfaces.UsuarioRepository usuarioRepository) {
        UsuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> findAll() {
        return UsuarioRepository.findAll();
    }

    @Override
    public Usuario findById(int id) {
        return UsuarioRepository.findById(id);
    }

    @Override
    public void save(Usuario usuario) {
        validarUsuario(usuario);
        UsuarioRepository.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        validarUsuario(usuario);
        UsuarioRepository.update(usuario);
    }

    @Override
    public void delete(int id) {
        UsuarioRepository.delete(id);
    }

    private void validarUsuario(Usuario usuario) {
        if (usuario.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario no puede estar vacío");
        }

    }
}