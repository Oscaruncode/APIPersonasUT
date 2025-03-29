package com.PPOOII.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.PPOOII.Entities.Persona;
import com.PPOOII.Services.PersonaServiceImpl;

@RestController
@RequestMapping("/APIPersonasV1/Personas")
public class PersonaController {

    @Autowired
    @Qualifier("PersonaService")
    private PersonaServiceImpl personaService;

    // Crear una persona
    @PostMapping("/persona")
    public boolean agregarPersona(@RequestBody @Validated Persona persona) {
        return personaService.guardar(persona);
    }

    // Actualizar una persona
    @PutMapping("/persona")
    public boolean editarPersona(@RequestBody @Validated Persona persona) {
        return personaService.actualizar(persona);
    }

    // Eliminar una persona por ID
    @DeleteMapping("/persona/{id}")
    public boolean eliminarPersona(@PathVariable("id") int id) {
        return personaService.eliminar(id);
    }

    // Obtener lista de personas con paginación
    @GetMapping("/personas")
    public List<Persona> listadoPersona(Pageable pageable) {
        return personaService.consultarPersona(pageable);
    }

    // Buscar persona por ID
    @GetMapping("/persona/id/{id}")
    public Optional<Persona> getById(@PathVariable("id") int id) {
        return personaService.findByIdentificacion(id);
    }

    // Buscar personas por primer nombre
    @GetMapping("/persona/pnombre/{pnombre}")
    public List<Persona> getByPNombre(@PathVariable("pnombre") String pnombre) {
        return personaService.findByPnombre(pnombre);
    }

    // Buscar personas por edad
    @GetMapping("/persona/edad/{edad}")
    public List<Persona> getByEdad(@PathVariable("edad") int edad) {
        return personaService.findByEdad(edad);
    }

    // Buscar personas por primer apellido
    @GetMapping("/persona/papellido/{papellido}")
    public List<Persona> getByPapellido(@PathVariable("papellido") String papellido) {
        return personaService.findByPapellido(papellido);
    }
}
