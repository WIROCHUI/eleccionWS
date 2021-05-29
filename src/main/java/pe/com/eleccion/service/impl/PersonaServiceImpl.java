/**
 * 
 */
package pe.com.eleccion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.eleccion.dao.PersonaDao;
import pe.com.eleccion.entity.Persona;

/**
 * @author Wilder Chui
 * Date 16 may. 2021
 * Version 1.0
 */
@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaDao pd;

	@Override
	@Transactional(readOnly = true)
	public Persona findById(Long id) {		
		return pd.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Persona savePersona(Persona persona) {		
		return pd.save(persona);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findPersona() {		
		return (List<Persona>) pd.findAll();
	}

}
