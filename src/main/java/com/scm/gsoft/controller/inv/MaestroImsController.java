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
import com.scm.gsoft.domain.inv.MaestroIms;
import com.scm.gsoft.service.inv.MaestroImsService;

@Controller
@RequestMapping("/v1/inv")
public class MaestroImsController {

	@Autowired
	private MaestroImsService _maestroImsService;

	//GET
	@RequestMapping(value = "/MaestroIms/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<MaestroIms> getMaestroImsById(@PathVariable("id") Long idMaestroIms){

		if(idMaestroIms == null || idMaestroIms <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		MaestroIms maestroIms = _maestroImsService.getMaestroImsById(idMaestroIms);
		if(maestroIms == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<MaestroIms>(maestroIms, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/MaestroIms", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<MaestroIms>> getMaestroImsByName(@RequestParam(value = "name", required = false) String name){

		List<MaestroIms> maestroImsList = new ArrayList<>();

		if(name == null) {

			maestroImsList = _maestroImsService.getMaestroImsList();

			if(maestroImsList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<MaestroIms>>(maestroImsList, HttpStatus.OK);

			}

		} else {

			MaestroIms maestroIms = _maestroImsService.getMaestroImsByName(name);

			if(maestroIms == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			maestroImsList.add(maestroIms);
			return new ResponseEntity<List<MaestroIms>>(maestroImsList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/MaestroIms", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createMaestroIms(@RequestBody MaestroIms maestroIms, UriComponentsBuilder uriComponentsBuilder){

		if(maestroIms.getNombre().equals(null)||maestroIms.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_maestroImsService.getMaestroImsByName(maestroIms.getNombre()) != null) {

			return new ResponseEntity("The MaestroIms already exist", HttpStatus.CONFLICT);

		}

		_maestroImsService.createMaestroIms(maestroIms);
		MaestroIms newMaestroIms = _maestroImsService.getMaestroImsByName(maestroIms.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/MaestroIms/{id}")
				.buildAndExpand(newMaestroIms.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/MaestroIms/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<MaestroIms> updateMaestroIms(@PathVariable("id") Long idMaestroIms, @RequestBody MaestroIms maestroIms){

		if(idMaestroIms == null || idMaestroIms <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		MaestroIms newMaestroIms = _maestroImsService.getMaestroImsById(idMaestroIms);
		if(newMaestroIms == null) {

			return new ResponseEntity("There's no MaestroIms with the id", HttpStatus.CONFLICT);

		}

		newMaestroIms.setNombre(maestroIms.getNombre());
		newMaestroIms.setUsuario(maestroIms.getUsuario());
		newMaestroIms.setStatReg(maestroIms.getStatReg());

		_maestroImsService.updateMaestroIms(newMaestroIms);
		return new ResponseEntity<MaestroIms>(newMaestroIms, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/MaestroIms/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteMaestroImsById(@PathVariable("id") Long idMaestroIms){

		if(idMaestroIms == null || idMaestroIms <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		MaestroIms maestroIms = _maestroImsService.getMaestroImsById(idMaestroIms);
		if(maestroIms == null) {

			return new ResponseEntity("Can't remove an inexistent MaestroIms", HttpStatus.CONFLICT);
		}

		_maestroImsService.removeMaestroIms(idMaestroIms);
		return new ResponseEntity(HttpStatus.OK);



	}

}
