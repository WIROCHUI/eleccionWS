/**
 * 
 */
package pe.com.eleccion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.eleccion.dao.InstitucionDao;
import pe.com.eleccion.entity.Institucion;

/**
 * @author Wilder Chui
 * Date 16 may. 2021
 * Version 1.0
 */
@Service
public class InstitucionServiceImpl implements InstitucionService{
	
	@Autowired
	private InstitucionDao institucionDao;

	@Override
	@Transactional(readOnly = true)
	public Institucion findById(Long Id) {		
		return institucionDao.findById(Id).orElse(null);
	}

	@Override
	@Transactional
	public Institucion saveInstitucion(Institucion institucion) {
		return institucionDao.save(institucion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Institucion> findInstitucion() {
		return (List<Institucion>) institucionDao.findAll();
	}

}
