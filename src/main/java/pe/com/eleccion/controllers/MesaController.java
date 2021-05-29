/**
 * 
 */
package pe.com.eleccion.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.eleccion.entity.Mesa;
import pe.com.eleccion.service.impl.MesaService;

/**
 * @author Wilder Chui
 * Date 17 may. 2021
 * Version 1.0
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/eleccion")
public class MesaController {
	
	@Autowired
	private MesaService mesaService;
	
	
	
	@PostMapping("/mesa")
	public ResponseEntity<?> create(@Valid @RequestBody Mesa mesa, BindingResult result) {
		Mesa mesaNuevo = null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo'"+ err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
					response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		try {
			mesaNuevo =  mesaService.saveMesa(mesa);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar en la base de datos " + "\n" + "- Datos duplicados o nulos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Agregado con exito!");
		response.put("cliente", mesaNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
