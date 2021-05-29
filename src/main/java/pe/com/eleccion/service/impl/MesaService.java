/**
 * 
 */
package pe.com.eleccion.service.impl;

import pe.com.eleccion.entity.Mesa;

/**
 * @author Wilder Chui
 * Date 16 may. 2021
 * Version 1.0
 */
public interface MesaService {

	public Mesa findById(Long id);
	public Mesa saveMesa(Mesa mesa);
}
