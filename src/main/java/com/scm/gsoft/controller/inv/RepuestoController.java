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
import com.scm.gsoft.domain.inv.Repuesto;
import com.scm.gsoft.service.inv.RepuestoService;

@Controller
@RequestMapping("/v1/inv")
public class RepuestoController {

	@Autowired
	private RepuestoService _repuestoService;

	//GET
	@RequestMapping(value = "/Repuesto/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Repuesto> getRepuestoById(@PathVariable("id") Long idRepuesto){

		if(idRepuesto == null || idRepuesto <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Repuesto repuesto = _repuestoService.getRepuestoById(idRepuesto);
		if(repuesto == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Repuesto>(repuesto, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Repuesto", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Repuesto>> getRepuestoByName(@RequestParam(value = "name", required = false) String name){

		List<Repuesto> repuestoList = new ArrayList<>();

		if(name == null) {

			repuestoList = _repuestoService.getRepuestoList();

			if(repuestoList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Repuesto>>(repuestoList, HttpStatus.OK);

			}

		} else {

			Repuesto repuesto = _repuestoService.getRepuestoByName(name);

			if(repuesto == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			repuestoList.add(repuesto);
			return new ResponseEntity<List<Repuesto>>(repuestoList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Repuesto", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createRepuesto(@RequestBody Repuesto repuesto, UriComponentsBuilder uriComponentsBuilder){

		if(repuesto.getPieza().equals(null)||repuesto.getPieza().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_repuestoService.getRepuestoByName(repuesto.getPieza()) != null) {

			return new ResponseEntity("The Repuesto already exist", HttpStatus.CONFLICT);

		}

		_repuestoService.createRepuesto(repuesto);
		Repuesto newRepuesto = _repuestoService.getRepuestoByName(repuesto.getPieza());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Repuesto/{id}")
				.buildAndExpand(newRepuesto.getIdRepuesto())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Repuesto/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Repuesto> updateRepuesto(@PathVariable("id") Long idRepuesto, @RequestBody Repuesto repuesto){

		if(idRepuesto == null || idRepuesto <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Repuesto newRepuesto = _repuestoService.getRepuestoById(idRepuesto);
		if(newRepuesto == null) {

			return new ResponseEntity("There's no Repuesto with the id", HttpStatus.CONFLICT);

		}

		newRepuesto.setIdTipo(repuesto.getIdTipo());

		_repuestoService.updateRepuesto(newRepuesto);
		return new ResponseEntity<Repuesto>(newRepuesto, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Repuesto/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteRepuestoById(@PathVariable("id") Long idRepuesto){

		if(idRepuesto == null || idRepuesto <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Repuesto repuesto = _repuestoService.getRepuestoById(idRepuesto);
		if(repuesto == null) {

			return new ResponseEntity("Can't remove an inexistent Repuesto", HttpStatus.CONFLICT);
		}

		_repuestoService.removeRepuesto(idRepuesto);
		return new ResponseEntity(HttpStatus.OK);



	}

}
