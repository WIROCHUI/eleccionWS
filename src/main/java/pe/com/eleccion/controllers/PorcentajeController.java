/**
 * 
 */
package pe.com.eleccion.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.eleccion.dto.PorcentajeGeneralDto;
import pe.com.eleccion.entity.Votacion;
import pe.com.eleccion.service.impl.VotacionService;

/**
 * @author Wilder Chui
 * Date 18 may. 2021
 * Version 1.0
 */

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/eleccion")
public class PorcentajeController {
	
	@Autowired
	private VotacionService votacionService;

	@SuppressWarnings("unused")
	@GetMapping("/conteo/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Votacion votacion = null;
		Map<String, Object> response = new HashMap<>();
		PorcentajeGeneralDto porcentajeGeneralDto;
		double numero1;
		double numero2;
		double total;
		try {
			votacion =  votacionService.findById(id);
			total = votacion.getTotalVotosEmitidos();
			numero2 = votacion.getPartidoCastillo();
			numero1 = votacion.getPartidoFujimori();
			double result1;
			double result2;
			double result3;
			double totalContado;
			
			result1 = total * (numero1 /100);
			result2 = total * (numero2 /100);
			totalContado = total * ((numero1+numero2) / 100);
			
			System.out.println("Porcentaje--> " + result1);
			System.out.println("Porcentaje--> " + result2);
			System.out.println("Nulo--> " + totalContado);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(votacion == null) {
			response.put("mensaje", "ID: ".concat(id.toString().concat(" no exite en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Votacion>(votacion,HttpStatus.OK);
	}
	
}
