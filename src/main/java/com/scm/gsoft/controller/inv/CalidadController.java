package com.scm.gsoft.controller.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;
import com.scm.gsoft.domain.inv.Calidad;
import com.scm.gsoft.service.inv.CalidadService;

@Controller
@RequestMapping("/v1/inv")
public class CalidadController {

	@Autowired
	private CalidadService _calidadService;

	//GET
	@RequestMapping(value = "/Calidad/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Calidad> getCalidadById(@PathVariable("id") Long idCalidad){

		if(idCalidad == null || idCalidad <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Calidad calidad = _calidadService.getCalidadById(idCalidad);
		if(calidad == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Calidad>(calidad, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Calidad", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Calidad>> getCalidadByName(@RequestParam(value = "name", required = false) String name){

		List<Calidad> calidadList = new ArrayList<>();

		if(name == null) {

			calidadList = _calidadService.getCalidadList();

			if(calidadList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Calidad>>(calidadList, HttpStatus.OK);

			}

		} else {

			Calidad calidad = _calidadService.getCalidadByName(name);

			if(calidad == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			calidadList.add(calidad);
			return new ResponseEntity<List<Calidad>>(calidadList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Calidad", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCalidad(@RequestBody Calidad calidad, UriComponentsBuilder uriComponentsBuilder){

		if(calidad.getCalidad().equals(null)||calidad.getCalidad().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_calidadService.getCalidadByName(calidad.getCalidad()) != null) {

			return new ResponseEntity("The Calidad already exist", HttpStatus.CONFLICT);

		}

		_calidadService.createCalidad(calidad);
		Calidad newCalidad = _calidadService.getCalidadByName(calidad.getCalidad());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Calidad/{id}")
				.buildAndExpand(newCalidad.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Calidad/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Calidad> updateCalidad(@PathVariable("id") Long idCalidad, @RequestBody Calidad calidad){

		if(idCalidad == null || idCalidad <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Calidad newCalidad = _calidadService.getCalidadById(idCalidad);
		if(newCalidad == null) {

			return new ResponseEntity("There's no Calidad with the id", HttpStatus.CONFLICT);

		}

		newCalidad.setUsuario(calidad.getUsuario());
		newCalidad.setStatReg(calidad.getStatReg());

		_calidadService.updateCalidad(newCalidad);
		return new ResponseEntity<Calidad>(newCalidad, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Calidad/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteCalidadById(@PathVariable("id") Long idCalidad){

		if(idCalidad == null || idCalidad <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Calidad calidad = _calidadService.getCalidadById(idCalidad);
		if(calidad == null) {

			return new ResponseEntity("Can't remove an inexistent Calidad", HttpStatus.CONFLICT);
		}

		_calidadService.removeCalidad(idCalidad);
		return new ResponseEntity(HttpStatus.OK);



	}

}
