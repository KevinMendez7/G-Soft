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
import com.scm.gsoft.domain.inv.Ingreso;
import com.scm.gsoft.service.inv.IngresoService;

@Controller
@RequestMapping("/v1/inv")
public class IngresoController {

	@Autowired
	private IngresoService _ingresoService;

	//GET
	@RequestMapping(value = "/Ingreso/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Ingreso> getIngresoById(@PathVariable("id") Long idIngreso){

		if(idIngreso == null || idIngreso <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Ingreso ingreso = _ingresoService.getIngresoById(idIngreso);
		if(ingreso == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Ingreso>(ingreso, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Ingreso", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Ingreso>> getIngresoByName(@RequestParam(value = "name", required = false) String name){

		List<Ingreso> ingresoList = new ArrayList<>();

		if(name == null) {

			ingresoList = _ingresoService.getIngresoList();

			if(ingresoList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Ingreso>>(ingresoList, HttpStatus.OK);

			}

		} else {

			Ingreso ingreso = _ingresoService.getIngresoByName(name);

			if(ingreso == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			ingresoList.add(ingreso);
			return new ResponseEntity<List<Ingreso>>(ingresoList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Ingreso", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createIngreso(@RequestBody Ingreso ingreso, UriComponentsBuilder uriComponentsBuilder){

		if(ingreso.getAnio().equals(null)||ingreso.getAnio().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_ingresoService.getIngresoByName(ingreso.getAnio()) != null) {

			return new ResponseEntity("The Ingreso already exist", HttpStatus.CONFLICT);

		}

		_ingresoService.createIngreso(ingreso);
		Ingreso newIngreso = _ingresoService.getIngresoByName(ingreso.getAnio());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Ingreso/{id}")
				.buildAndExpand(newIngreso.getIdIngreso())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Ingreso/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Ingreso> updateIngreso(@PathVariable("id") Long idIngreso, @RequestBody Ingreso ingreso){

		if(idIngreso == null || idIngreso <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Ingreso newIngreso = _ingresoService.getIngresoById(idIngreso);
		if(newIngreso == null) {

			return new ResponseEntity("There's no Ingreso with the id", HttpStatus.CONFLICT);

		}

		newIngreso.setStatReg(ingreso.getStatReg());

		_ingresoService.updateIngreso(newIngreso);
		return new ResponseEntity<Ingreso>(newIngreso, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Ingreso/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteIngresoById(@PathVariable("id") Long idIngreso){

		if(idIngreso == null || idIngreso <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Ingreso ingreso = _ingresoService.getIngresoById(idIngreso);
		if(ingreso == null) {

			return new ResponseEntity("Can't remove an inexistent Ingreso", HttpStatus.CONFLICT);
		}

		_ingresoService.removeIngreso(idIngreso);
		return new ResponseEntity(HttpStatus.OK);



	}

}
