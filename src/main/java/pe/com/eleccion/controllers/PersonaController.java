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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.eleccion.entity.Persona;
import pe.com.eleccion.service.impl.PersonaService;

/**
 * @author Wilder Chui
 * Date 16 may. 2021
 * Version 1.0
 */

@CrossOrigin(origins = {"http://localhost:4200","https://login-ng-4d94a.web.app"})
@RestController
@RequestMapping("/eleccion")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/persona")
	public List<Persona>index(){
		return personaService.findPersona();
	}
	
	@GetMapping("/persona/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Persona per = null;
		Map<String, Object> response = new HashMap<>();

		try {
			per =  personaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(per == null) {
			response.put("mensaje", "ID: ".concat(id.toString().concat(" no exite en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Persona>(per,HttpStatus.OK);
	}
	

	@GetMapping("/buscarPersona/{dni}")
	public ResponseEntity<?> show(@PathVariable int dni) {
		Persona per = null;
		Map<String, Object> response = new HashMap<>();

		try {
			per =  personaService.findByDni(dni);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		String ddni = String.valueOf(dni);	
		
		
		if (per == null) {
			response.put("mensaje", "DNI: ".concat(ddni.concat(" no exite en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		} else if (per.getFlgGrabado() == 1) {
			response.put("mensaje", "El DNI: ".concat(String.valueOf(dni).concat(" ya registro su acta de votación")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Persona>(per,HttpStatus.OK);
	}
	
	@PostMapping("/persona")
	public ResponseEntity<?> create(@Valid @RequestBody Persona persona, BindingResult result) {
		Persona personaNuevo = null;
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
			personaNuevo =  personaService.savePersona(persona);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar en la base de datos " + "\n" + "- Datos duplicados o nulos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Agregado con exito!");
		response.put("cliente", personaNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
