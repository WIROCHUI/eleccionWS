/**
 * 
 */
package pe.com.eleccion.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Persona> findPersonaByDistritoAndFlg(int idDistrito, int flg) {
		try {
            return  em.createNamedQuery("Persona.findAllFlagAndDistrito")
            		.setParameter("flgGrabado", flg)
                    .setParameter("idDistrito", Long.valueOf(idDistrito))
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
	}

	@Override
	public Persona findByIdDistritoAndFlgGrabado(int idDistrito, int flgGrabado) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT sum(peru_libre) as peru_libre, sum(fuerza_popular) as fuerza_popular, sum(voto_blanco) as voto_blanco, ");
			sql.append("sum(voto_nulo) as voto_nulo, sum(voto_impugnado) as voto_impugnado, sum(total_voto_emitido) as total_voto_emitido ");
			sql.append("FROM persona ");
			sql.append("WHERE id_distrito=?1 and flg_grabado=?2 group by flg_grabado; ");
			Query query = em.createNativeQuery(sql.toString());
            query.setParameter(1, idDistrito);
            query.setParameter(2, flgGrabado);

            Object[] result = (Object[]) query.getSingleResult();
            return new Persona(((BigInteger) result[0]).intValue(), ((BigInteger) result[1]).intValue(), ((BigInteger) result[2]).intValue(),
            					((BigInteger) result[3]).intValue(), ((BigInteger) result[4]).intValue(), ((BigInteger) result[5]).intValue());
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
	}

}
