package com.PPOOII.Services;

import org.springframework.stereotype.Service;
import com.PPOOII.Repository.UsuarioRepository;
import com.PPOOII.Entities.Usuario;

@Service
public class UsuarioServiceImpl {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario cambiarPassword(Long idPersona, String nuevoPassword) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByIdPersona(idPersona);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setPassword(nuevoPassword); // Aquí puedes aplicar una encriptación si es necesario
            return usuarioRepository.save(usuario);
        }
        throw new RuntimeException("Usuario no encontrado");
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long idPersona) {
        return usuarioRepository.findByIdPersona(idPersona);
    }

    @Override
    public String obtenerApiKey(Long idPersona) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByIdPersona(idPersona);
        return usuarioOpt.map(Usuario::getApikey).orElseThrow(() -> new RuntimeException("API Key no encontrada"));
    }
}
