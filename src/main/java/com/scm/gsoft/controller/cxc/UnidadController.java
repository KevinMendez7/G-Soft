package com.scm.gsoft.controller.cxc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.scm.gsoft.domain.cxc.Unidad;
import com.scm.gsoft.service.cxc.UnidadService;

@Controller("UnidadControllerCxc")
@RequestMapping("/v1/cxc")
public class UnidadController {

	@Autowired
	@Qualifier("UnidadServiceCxc")
	private UnidadService _unidadService;

	//GET
	@RequestMapping(value = "/Unidad/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Unidad> getUnidadById(@PathVariable("id") Long idUnidad){

		if(idUnidad == null || idUnidad <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Unidad unidad = _unidadService.getUnidadById(idUnidad);
		if(unidad == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Unidad>(unidad, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Unidad", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Unidad>> getUnidadByName(@RequestParam(value = "name", required = false) String name){

		List<Unidad> unidadList = new ArrayList<>();

		if(name == null) {

			unidadList = _unidadService.getUnidadList();

			if(unidadList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Unidad>>(unidadList, HttpStatus.OK);

			}

		} else {

			Unidad unidad = _unidadService.getUnidadByName(name);

			if(unidad == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			unidadList.add(unidad);
			return new ResponseEntity<List<Unidad>>(unidadList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Unidad", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createUnidad(@RequestBody Unidad unidad, UriComponentsBuilder uriComponentsBuilder){

		if(unidad.getCodigo().equals(null)||unidad.getCodigo().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_unidadService.getUnidadByName(unidad.getCodigo()) != null) {

			return new ResponseEntity("The Unidad already exist", HttpStatus.CONFLICT);

		}

		_unidadService.createUnidad(unidad);
		Unidad newUnidad = _unidadService.getUnidadByName(unidad.getCodigo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Unidad/{id}")
				.buildAndExpand(newUnidad.getIdUnidad())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Unidad/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Unidad> updateUnidad(@PathVariable("id") Long idUnidad, @RequestBody Unidad unidad){

		if(idUnidad == null || idUnidad <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Unidad newUnidad = _unidadService.getUnidadById(idUnidad);
		if(newUnidad == null) {

			return new ResponseEntity("There's no Unidad with the id", HttpStatus.CONFLICT);

		}

		newUnidad.setCodigo(unidad.getCodigo());		

		_unidadService.updateUnidad(newUnidad);
		return new ResponseEntity<Unidad>(newUnidad, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Unidad/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteUnidadById(@PathVariable("id") Long idUnidad){

		if(idUnidad == null || idUnidad <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Unidad unidad = _unidadService.getUnidadById(idUnidad);
		if(unidad == null) {

			return new ResponseEntity("Can't remove an inexistent Unidad", HttpStatus.CONFLICT);
		}

		_unidadService.removeUnidad(idUnidad);
		return new ResponseEntity(HttpStatus.OK);



	}

}
