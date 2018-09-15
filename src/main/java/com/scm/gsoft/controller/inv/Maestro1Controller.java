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
import com.scm.gsoft.domain.inv.Maestro1;
import com.scm.gsoft.service.inv.Maestro1Service;

@Controller
@RequestMapping("/v1/inv")
public class Maestro1Controller {

	@Autowired
	private Maestro1Service _maestro1Service;

	//GET
	@RequestMapping(value = "/Maestro1/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Maestro1> getMaestro1ById(@PathVariable("id") Long idMaestro1){

		if(idMaestro1 == null || idMaestro1 <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Maestro1 maestro1 = _maestro1Service.getMaestro1ById(idMaestro1);
		if(maestro1 == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Maestro1>(maestro1, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Maestro1", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Maestro1>> getMaestro1ByName(@RequestParam(value = "name", required = false) String name){

		List<Maestro1> maestro1List = new ArrayList<>();

		if(name == null) {

			maestro1List = _maestro1Service.getMaestro1List();

			if(maestro1List.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Maestro1>>(maestro1List, HttpStatus.OK);

			}

		} else {

			Maestro1 maestro1 = _maestro1Service.getMaestro1ByName(name);

			if(maestro1 == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			maestro1List.add(maestro1);
			return new ResponseEntity<List<Maestro1>>(maestro1List, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Maestro1", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createMaestro1(@RequestBody Maestro1 maestro1, UriComponentsBuilder uriComponentsBuilder){

		if(maestro1.getNombre().equals(null)||maestro1.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_maestro1Service.getMaestro1ByName(maestro1.getNombre()) != null) {

			return new ResponseEntity("The Maestro1 already exist", HttpStatus.CONFLICT);

		}

		_maestro1Service.createMaestro1(maestro1);
		Maestro1 newMaestro1 = _maestro1Service.getMaestro1ByName(maestro1.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Maestro1/{id}")
				.buildAndExpand(newMaestro1.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Maestro1/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Maestro1> updateMaestro1(@PathVariable("id") Long idMaestro1, @RequestBody Maestro1 maestro1){

		if(idMaestro1 == null || idMaestro1 <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Maestro1 newMaestro1 = _maestro1Service.getMaestro1ById(idMaestro1);
		if(newMaestro1 == null) {

			return new ResponseEntity("There's no Maestro1 with the id", HttpStatus.CONFLICT);

		}
	
		newMaestro1.setNombre(maestro1.getNombre());
		newMaestro1.setUsuario(maestro1.getUsuario());
		newMaestro1.setStatReg(maestro1.getStatReg());

		_maestro1Service.updateMaestro1(newMaestro1);
		return new ResponseEntity<Maestro1>(newMaestro1, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Maestro1/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteMaestro1ById(@PathVariable("id") Long idMaestro1){

		if(idMaestro1 == null || idMaestro1 <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Maestro1 maestro1 = _maestro1Service.getMaestro1ById(idMaestro1);
		if(maestro1 == null) {

			return new ResponseEntity("Can't remove an inexistent Maestro1", HttpStatus.CONFLICT);
		}

		_maestro1Service.removeMaestro1(idMaestro1);
		return new ResponseEntity(HttpStatus.OK);



	}

}
