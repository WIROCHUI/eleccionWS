/**
 * 
 */
package pe.com.eleccion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.eleccion.dao.DistritoDao;
import pe.com.eleccion.entity.Distrito;;

/**
 * @author Wilder Chui
 * Date 17 may. 2021
 * Version 1.0
 */
@Service
public class DistritoServiceImpl implements DistritoService{
	
	@Autowired
	private DistritoDao distritoDao;

	@Override
	public Distrito findById(Long id) {
		return distritoDao.findById(id).orElse(null);
	}

	@Override
	public Distrito saveDistrito(Distrito distrito) {
		return distritoDao.save(distrito);
	}

	@Override
	public List<Distrito> findDistrito() {
		return (List<Distrito>) distritoDao.findAll();
	}

}
