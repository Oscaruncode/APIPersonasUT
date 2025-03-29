package com.PPOOII.Repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.PPOOII.Entities.Usuario;

@Repository
public interface UsuarioRepository {
    Optional<Usuario> findByIdPersona(Long idPersona);
}
