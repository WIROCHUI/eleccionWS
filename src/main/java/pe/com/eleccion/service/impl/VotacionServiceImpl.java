/**
 * 
 */
package pe.com.eleccion.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.eleccion.dao.VotacionDao;
import pe.com.eleccion.entity.Votacion;

/**
 * @author Wilder Chui
 * Date 17 may. 2021
 * Version 1.0
 */
@Service
public class VotacionServiceImpl implements VotacionService{
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
    private EntityManager em;
	
	@Autowired
	private VotacionDao votacionDao;

	@Override
	public List<Votacion> findVotacion() {
		return (List<Votacion>) votacionDao.findAll();
	}

	@Override
	public Votacion findById(Long id) {
		return votacionDao.findById(id).orElse(null);
	}

}
