package com.PPOOII.Controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.PPOOII.Entities.Usuario;
import com.PPOOII.Services.UsuarioServiceImpl;

@RestController
@RequestMapping("/APIPersonasV1/usuario")
public class UsuarioController {
	 @Autowired
	    private UsuarioServiceImpl usuarioService;

	    // Cambiar contraseña
	    @PutMapping("/cambiarPassword/{idPersona}")
	    public Usuario cambiarPassword(@PathVariable("idPersona") Long idPersona, @RequestParam("nuevoPassword") String nuevoPassword) {
	        return usuarioService.cambiarPassword(idPersona, nuevoPassword);
	    }

	    // Obtener usuario por ID de persona
	    @GetMapping("/{idPersona}")
	    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable("idPersona") Long idPersona) {
	        return usuarioService.obtenerUsuarioPorId(idPersona);
	    }

	    // Obtener API Key
	    @GetMapping("/apikey/{idPersona}")
	    public String obtenerApiKey(@PathVariable("idPersona") Long idPersona) {
	        return usuarioService.obtenerApiKey(idPersona);
	    }
}