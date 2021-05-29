/**
 * 
 */
package pe.com.eleccion.service.impl;

import java.util.List;

import pe.com.eleccion.entity.Votacion;

/**
 * @author Wilder Chui
 * Date 17 may. 2021
 * Version 1.0
 */
public interface VotacionService {
	
	public Votacion findById(Long id);
	
	public List<Votacion> findVotacion();

}
