package com.PPOOII.Services;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.PPOOII.Entities.Persona;
import com.PPOOII.Repository.PersonaRepository;


@Service("PersonaService")
public class PersonaServiceImpl {
	// ========= INYECCIÓN DE DEPENDENCIAS ==========
    @Autowired
    @Qualifier("IPersonaRepository")
    private PersonaRepository personaRepository;

    // ========= LOGS ==========
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(PersonaServiceImpl.class);

    // ========== GUARDAR ==========
    public boolean guardar(Persona persona) {
        try {
            if (persona == null) {
                logger.error("ERROR: La persona es nula");
                return false;
            }
            personaRepository.save(persona);
            return true;
        } catch (Exception e) {
            logger.error("ERROR: No se pudo guardar la persona", e);
            return false;
        }
    }

    // ========== ACTUALIZAR ==========
    public boolean actualizar(Persona persona) {
        try {
            if (persona == null || persona.getId() == 0) {
                logger.error("ERROR: La persona es nula o su ID es 0");
                return false;
            }
            personaRepository.save(persona);
            return true;
        } catch (Exception e) {
            logger.error("ERROR: No se pudo actualizar la persona", e);
            return false;
        }
    }

    // ========== ELIMINAR ==========
    public boolean eliminar(int id) {
        try {
            Optional<Persona> persona = personaRepository.findById(id);
            if (persona.isPresent()) {
                personaRepository.delete(persona.get());
                return true;
            } else {
                logger.error("ERROR: No se encontró la persona con ID " + id);
                return false;
            }
        } catch (Exception e) {
            logger.error("ERROR: No se pudo eliminar la persona", e);
            return false;
        }
    }

    // ========== CONSULTAR TODAS LAS PERSONAS ==========
    public List<Persona> consultarPersona(Pageable pageable) {
        return personaRepository.findAll(pageable).getContent();
    }

    // ========== MÉTODOS DE BÚSQUEDA ==========
    
    // 🔍 a. Buscar por número de identificación
    public Optional<Persona> findByIdentificacion(int identificacion) {
        return personaRepository.findByIdentificacion(identificacion);
    }

    // 🔍 b. Buscar por edad
    public List<Persona> findByEdad(int edad) {
        return personaRepository.findByEdad(edad);
    }

    // 🔍 c. Buscar por primer apellido   
    public List<Persona> findByPapellido(String papellido) {
        return personaRepository.findByPapellido(papellido);
    }

    // 🔍 d. Buscar por primer nombre
    public List<Persona> findByPnombre(String pnombre) {
        return personaRepository.findByPnombre(pnombre);
    }
}
