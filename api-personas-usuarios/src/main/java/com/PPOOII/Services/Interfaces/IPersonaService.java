package com.PPOOII.Services.Interfaces;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import com.PPOOII.Entities.Persona;

public interface IPersonaService {

    boolean guardar(Persona persona);
    boolean actualizar(Persona persona);
    boolean eliminar(int id);
    List<Persona> consultarPersona(Pageable pageable);

    // Métodos de búsqueda
    Optional<Persona> findByIdentificacion(int identificacion);
    List<Persona> findByEdad(int edad);
    List<Persona> findByPapellido(String papellido);
    List<Persona> findByPnombre(String pnombre);
}