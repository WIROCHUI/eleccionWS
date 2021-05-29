/**
 * 
 */
package pe.com.eleccion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.eleccion.entity.Votacion;

/**
 * @author Wilder Chui
 * Date 17 may. 2021
 * Version 1.0
 */
public interface VotacionDao extends JpaRepository<Votacion, Long>{

}
