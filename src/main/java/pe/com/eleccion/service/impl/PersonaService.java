/**
 * 
 */
package pe.com.eleccion.service.impl;

import java.util.List;

import pe.com.eleccion.entity.Persona;

/**
 * @author Wilder Chui
 * Date 16 may. 2021
 * Version 1.0
 */
public interface PersonaService {

	public Persona findById(Long id);
	public Persona savePersona(Persona persona);
	public List<Persona> findPersona();
	public Persona findByDni(int dni);
	public List<Persona> findPersonaByDistritoAndFlg(int idDistrito, int flg);
	public Persona findByIdDistritoAndFlgGrabado(int idDistrito, int flgGrabado);
	
}
