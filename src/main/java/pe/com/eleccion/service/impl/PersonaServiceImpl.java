/**
 * 
 */
package pe.com.eleccion.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger log = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
    private EntityManager em;
	
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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Persona> findPersona() {
		try {
            return  em.createNamedQuery("Persona.findAllFlag")
                    .setParameter("flgGrabado", 1)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findByDni(int dni) {
		try {
            return (Persona) em.createNamedQuery("Persona.findByDni").setParameter("dni", dni).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
	}

}
