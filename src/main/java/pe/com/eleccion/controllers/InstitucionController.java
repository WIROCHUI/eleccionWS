/**
 * 
 */
package pe.com.eleccion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.eleccion.entity.Institucion;
import pe.com.eleccion.service.impl.InstitucionService;

/**
 * @author Wilder Chui
 * Date 16 may. 2021
 * Version 1.0
 */

@CrossOrigin(origins = {"http://localhost:4200","https://login-ng-4d94a.web.app"})
@RestController
@RequestMapping("/eleccion")
public class InstitucionController {
	
	@Autowired
	private InstitucionService InstitucionService;

	@GetMapping("/institucion")
	public List<Institucion>index(){
		return InstitucionService.findInstitucion();
	}
	
}
