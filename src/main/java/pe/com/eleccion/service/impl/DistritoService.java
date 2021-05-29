/**
 * 
 */
package pe.com.eleccion.service.impl;

import java.util.List;

import pe.com.eleccion.entity.Distrito;

/**
 * @author Wilder Chui
 * Date 17 may. 2021
 * Version 1.0
 */
public interface DistritoService {
	
	public Distrito findById(Long id);
	
	public Distrito saveDistrito(Distrito distrito);
	
	public List<Distrito> findDistrito();

}
