/**
 * 
 */
package pe.com.eleccion.service.impl;

import java.util.List;

import pe.com.eleccion.entity.Institucion;

/**
 * @author Wilder Chui
 * Date 16 may. 2021
 * Version 1.0
 */
public interface InstitucionService {
	
	public Institucion findById(Long Id);
	
	public Institucion saveInstitucion(Institucion institucion);
	
	public List<Institucion> findInstitucion();
}
