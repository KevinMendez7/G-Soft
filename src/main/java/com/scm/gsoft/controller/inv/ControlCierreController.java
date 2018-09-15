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
import com.scm.gsoft.domain.inv.ControlCierre;
import com.scm.gsoft.service.inv.ControlCierreService;

@Controller
@RequestMapping("/v1/inv")
public class ControlCierreController {

	@Autowired
	private ControlCierreService _controlCierreService;

	//GET
	@RequestMapping(value = "/ControlCierre/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<ControlCierre> getControlCierreById(@PathVariable("id") Long idControlCierre){

		if(idControlCierre == null || idControlCierre <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		ControlCierre controlCierre = _controlCierreService.getControlCierreById(idControlCierre);
		if(controlCierre == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<ControlCierre>(controlCierre, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/ControlCierre", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<ControlCierre>> getControlCierreByName(@RequestParam(value = "name", required = false) String name){

		List<ControlCierre> controlCierreList = new ArrayList<>();

		if(name == null) {

			controlCierreList = _controlCierreService.getControlCierreList();

			if(controlCierreList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<ControlCierre>>(controlCierreList, HttpStatus.OK);

			}

		} else {

			ControlCierre controlCierre = _controlCierreService.getControlCierreByName(name);

			if(controlCierre == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			controlCierreList.add(controlCierre);
			return new ResponseEntity<List<ControlCierre>>(controlCierreList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/ControlCierre", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createControlCierre(@RequestBody ControlCierre controlCierre, UriComponentsBuilder uriComponentsBuilder){

		if(controlCierre.getAnioActual().equals(null)||controlCierre.getAnioActual().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_controlCierreService.getControlCierreByName(controlCierre.getAnioActual()) != null) {

			return new ResponseEntity("The ControlCierre already exist", HttpStatus.CONFLICT);

		}

		_controlCierreService.createControlCierre(controlCierre);
		ControlCierre newControlCierre = _controlCierreService.getControlCierreByName(controlCierre.getAnioActual());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/ControlCierre/{id}")
				.buildAndExpand(newControlCierre.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/ControlCierre/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<ControlCierre> updateControlCierre(@PathVariable("id") Long idControlCierre, @RequestBody ControlCierre controlCierre){

		if(idControlCierre == null || idControlCierre <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		ControlCierre newControlCierre = _controlCierreService.getControlCierreById(idControlCierre);
		if(newControlCierre == null) {

			return new ResponseEntity("There's no ControlCierre with the id", HttpStatus.CONFLICT);

		}

		newControlCierre.setUsuario(controlCierre.getUsuario());
		newControlCierre.setStatReg(controlCierre.getStatReg());

		_controlCierreService.updateControlCierre(newControlCierre);
		return new ResponseEntity<ControlCierre>(newControlCierre, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/ControlCierre/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteControlCierreById(@PathVariable("id") Long idControlCierre){

		if(idControlCierre == null || idControlCierre <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		ControlCierre controlCierre = _controlCierreService.getControlCierreById(idControlCierre);
		if(controlCierre == null) {

			return new ResponseEntity("Can't remove an inexistent ControlCierre", HttpStatus.CONFLICT);
		}

		_controlCierreService.removeControlCierre(idControlCierre);
		return new ResponseEntity(HttpStatus.OK);



	}

}
