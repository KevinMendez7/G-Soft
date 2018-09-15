package com.scm.gsoft.controller.cxc;

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
import com.scm.gsoft.domain.cxc.Dctos;
import com.scm.gsoft.service.cxc.DctosService;

@Controller
@RequestMapping("/v1/cxc")
public class DctosController {

	@Autowired
	private DctosService _dctosService;

	//GET
	@RequestMapping(value = "/Dctos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Dctos> getDctosById(@PathVariable("id") Long idDctos){

		if(idDctos == null || idDctos <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Dctos dctos = _dctosService.getDctosById(idDctos);
		if(dctos == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Dctos>(dctos, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Dctos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Dctos>> getDctosByName(@RequestParam(value = "name", required = false) String name){

		List<Dctos> dctosList = new ArrayList<>();

		if(name == null) {

			dctosList = _dctosService.getDctosList();

			if(dctosList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Dctos>>(dctosList, HttpStatus.OK);

			}

		} else {

			Dctos dctos = _dctosService.getDctosByName(name);

			if(dctos == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			dctosList.add(dctos);
			return new ResponseEntity<List<Dctos>>(dctosList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Dctos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createDctos(@RequestBody Dctos dctos, UriComponentsBuilder uriComponentsBuilder){

		if(dctos.getCodigo().equals(null)||dctos.getCodigo().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_dctosService.getDctosByName(dctos.getCodigo()) != null) {

			return new ResponseEntity("The Dctos already exist", HttpStatus.CONFLICT);

		}

		_dctosService.createDctos(dctos);
		Dctos newDctos = _dctosService.getDctosByName(dctos.getCodigo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Dctos/{id}")
				.buildAndExpand(newDctos.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Dctos/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Dctos> updateDctos(@PathVariable("id") Long idDctos, @RequestBody Dctos dctos){

		if(idDctos == null || idDctos <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Dctos newDctos = _dctosService.getDctosById(idDctos);
		if(newDctos == null) {

			return new ResponseEntity("There's no Dctos with the id", HttpStatus.CONFLICT);

		}

		newDctos.setCodigo(dctos.getCodigo());	
		newDctos.setUsuario(dctos.getUsuario());
		newDctos.setStatReg(dctos.getStatReg());

		_dctosService.updateDctos(newDctos);
		return new ResponseEntity<Dctos>(newDctos, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Dctos/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteDctosById(@PathVariable("id") Long idDctos){

		if(idDctos == null || idDctos <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Dctos dctos = _dctosService.getDctosById(idDctos);
		if(dctos == null) {

			return new ResponseEntity("Can't remove an inexistent Dctos", HttpStatus.CONFLICT);
		}

		_dctosService.removeDctos(idDctos);
		return new ResponseEntity(HttpStatus.OK);



	}

}
