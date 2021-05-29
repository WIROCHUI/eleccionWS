/**
 * 
 */
package pe.com.eleccion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.eleccion.dao.MesaDao;
import pe.com.eleccion.entity.Mesa;

/**
 * @author Wilder Chui
 * Date 16 may. 2021
 * Version 1.0
 */
@Service
public class MesaServiceImpl implements MesaService{
	
	@Autowired
	private MesaDao mesaDao;

	@Override
	public Mesa findById(Long id) {
		return mesaDao.findById(id).orElse(null);
	}

	@Override
	public Mesa saveMesa(Mesa mesa) {
		return mesaDao.save(mesa);
	}

}
