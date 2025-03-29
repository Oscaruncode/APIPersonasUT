package com.PPOOII.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.PPOOII.Entities.Persona;


@Repository("IPersonaRepository")
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    // Buscar por ID (JpaRepository ya tiene findById, pero lo dejamos con Optional)
    Optional<Persona> findById(int id);

    // Buscar por número de identificación
    Optional<Persona> findByIdentificacion(int identificacion);

    // Buscar por primer nombre
    List<Persona> findByPnombre(String pnombre);

    // Buscar por primer apellido
    List<Persona> findByPapellido(String papellido);

    // Buscar por edad
    List<Persona> findByEdad(int edad);

    // Listar paginado
    Page<Persona> findAll(Pageable pageable);
}