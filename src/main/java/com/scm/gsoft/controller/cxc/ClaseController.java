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
import com.scm.gsoft.domain.cxc.Clase;
import com.scm.gsoft.service.cxc.ClaseService;

@Controller("ClaseControllerCxc")
@RequestMapping("/v1/cxc")
public class ClaseController {

	@Autowired
	@Qualifier("ClaseServiceCxc")
	private ClaseService _claseService;

	//GET
	@RequestMapping(value = "/Clase/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Clase> getClaseById(@PathVariable("id") Long idClase){

		if(idClase == null || idClase <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Clase clase = _claseService.getClaseById(idClase);
		if(clase == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Clase>(clase, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Clase", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Clase>> getClaseByName(@RequestParam(value = "name", required = false) String name){

		List<Clase> claseList = new ArrayList<>();

		if(name == null) {

			claseList = _claseService.getClaseList();

			if(claseList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Clase>>(claseList, HttpStatus.OK);

			}

		} else {

			Clase clase = _claseService.getClaseByName(name);

			if(clase == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			claseList.add(clase);
			return new ResponseEntity<List<Clase>>(claseList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Clase", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createClase(@RequestBody Clase clase, UriComponentsBuilder uriComponentsBuilder){

		if(clase.getConcepto().equals(null)||clase.getConcepto().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_claseService.getClaseByName(clase.getConcepto()) != null) {

			return new ResponseEntity("The Clase already exist", HttpStatus.CONFLICT);

		}

		_claseService.createClase(clase);
		Clase newClase = _claseService.getClaseByName(clase.getConcepto());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Clase/{id}")
				.buildAndExpand(newClase.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Clase/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Clase> updateClase(@PathVariable("id") Long idClase, @RequestBody Clase clase){

		if(idClase == null || idClase <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Clase newClase = _claseService.getClaseById(idClase);
		if(newClase == null) {

			return new ResponseEntity("There's no Clase with the id", HttpStatus.CONFLICT);

		}

		newClase.setCodigo(clase.getCodigo());		
		newClase.setUsuario(clase.getUsuario());
		newClase.setStatReg(clase.getStatReg());

		_claseService.updateClase(newClase);
		return new ResponseEntity<Clase>(newClase, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Clase/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteClaseById(@PathVariable("id") Long idClase){

		if(idClase == null || idClase <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Clase clase = _claseService.getClaseById(idClase);
		if(clase == null) {

			return new ResponseEntity("Can't remove an inexistent Clase", HttpStatus.CONFLICT);
		}

		_claseService.removeClase(idClase);
		return new ResponseEntity(HttpStatus.OK);



	}

}
