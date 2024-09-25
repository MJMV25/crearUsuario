package org.example.service;

import org.example.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findById(int id);
    void save(Usuario usuario);
    static void update(Usuario usuario);
    static void delete(int id);
}
