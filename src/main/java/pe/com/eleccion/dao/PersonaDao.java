/**
 * 
 */
package pe.com.eleccion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.eleccion.entity.Persona;

/**
 * @author Wilder Chui
 * Date 16 may. 2021
 * Version 1.0
 */
public interface PersonaDao extends JpaRepository<Persona, Long>{

}
