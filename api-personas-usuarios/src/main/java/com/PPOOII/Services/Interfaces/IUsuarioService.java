package com.PPOOII.Services.Interfaces;
import com.PPOOII.Entities.Usuario;
import java.util.Optional;


public interface IUsuarioService {
	  	Usuario cambiarPassword(Long idPersona, String nuevoPassword);
	    Optional<Usuario> obtenerUsuarioPorId(Long idPersona);
	    String obtenerApiKey(Long idPersona);
}
