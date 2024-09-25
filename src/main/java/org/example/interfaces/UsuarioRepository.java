package org.example.interfaces;
import java.util.List;
import org.example.domain.Usuario;

public interface UsuarioRepository {
    List<Usuario> findAll();
    Usuario findById(int id);
    void save(Usuario usuario);
    void update(Usuario usuario);
    void delete(int id);
}