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
import com.scm.gsoft.domain.inv.Similaridad;
import com.scm.gsoft.service.inv.SimilaridadService;

@Controller
@RequestMapping("/v1/inv")
public class SimilaridadController {

	@Autowired
	private SimilaridadService _similaridadService;

	//GET
	@RequestMapping(value = "/Similaridad/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Similaridad> getSimilaridadById(@PathVariable("id") Long idSimilaridad){

		if(idSimilaridad == null || idSimilaridad <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Similaridad similaridad = _similaridadService.getSimilaridadById(idSimilaridad);
		if(similaridad == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Similaridad>(similaridad, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Similaridad", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Similaridad>> getSimilaridadByName(@RequestParam(value = "name", required = false) String name){

		List<Similaridad> similaridadList = new ArrayList<>();

		if(name == null) {

			similaridadList = _similaridadService.getSimilaridadList();

			if(similaridadList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Similaridad>>(similaridadList, HttpStatus.OK);

			}

		} else {

			Similaridad similaridad = _similaridadService.getSimilaridadByName(name);

			if(similaridad == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			similaridadList.add(similaridad);
			return new ResponseEntity<List<Similaridad>>(similaridadList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Similaridad", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createSimilaridad(@RequestBody Similaridad similaridad, UriComponentsBuilder uriComponentsBuilder){

		if(similaridad.getAnios().equals(null)||similaridad.getAnios().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_similaridadService.getSimilaridadByName(similaridad.getAnios()) != null) {

			return new ResponseEntity("The Similaridad already exist", HttpStatus.CONFLICT);

		}

		_similaridadService.createSimilaridad(similaridad);
		Similaridad newSimilaridad = _similaridadService.getSimilaridadByName(similaridad.getAnios());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Similaridad/{id}")
				.buildAndExpand(newSimilaridad.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Similaridad/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Similaridad> updateSimilaridad(@PathVariable("id") Long idSimilaridad, @RequestBody Similaridad similaridad){

		if(idSimilaridad == null || idSimilaridad <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Similaridad newSimilaridad = _similaridadService.getSimilaridadById(idSimilaridad);
		if(newSimilaridad == null) {

			return new ResponseEntity("There's no Similaridad with the id", HttpStatus.CONFLICT);

		}

		newSimilaridad.setUsuario(similaridad.getUsuario());
		newSimilaridad.setStatReg(similaridad.getStatReg());

		_similaridadService.updateSimilaridad(newSimilaridad);
		return new ResponseEntity<Similaridad>(newSimilaridad, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Similaridad/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteSimilaridadById(@PathVariable("id") Long idSimilaridad){

		if(idSimilaridad == null || idSimilaridad <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Similaridad similaridad = _similaridadService.getSimilaridadById(idSimilaridad);
		if(similaridad == null) {

			return new ResponseEntity("Can't remove an inexistent Similaridad", HttpStatus.CONFLICT);
		}

		_similaridadService.removeSimilaridad(idSimilaridad);
		return new ResponseEntity(HttpStatus.OK);



	}

}
