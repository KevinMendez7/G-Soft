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
import com.scm.gsoft.domain.cxc.DetVarios;
import com.scm.gsoft.service.cxc.DetVariosService;

@Controller
@RequestMapping("/v1/cxc")
public class DetVariosController {

	@Autowired
	private DetVariosService _detVariosService;

	//GET
	@RequestMapping(value = "/DetVarios/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<DetVarios> getDetVariosById(@PathVariable("id") Long idDetVarios){

		if(idDetVarios == null || idDetVarios <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		DetVarios detVarios = _detVariosService.getDetVariosById(idDetVarios);
		if(detVarios == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<DetVarios>(detVarios, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/DetVarios", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<DetVarios>> getDetVariosByName(@RequestParam(value = "name", required = false) String name){

		List<DetVarios> detVariosList = new ArrayList<>();

		if(name == null) {

			detVariosList = _detVariosService.getDetVariosList();

			if(detVariosList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<DetVarios>>(detVariosList, HttpStatus.OK);

			}

		} else {

			DetVarios detVarios = _detVariosService.getDetVariosByName(name);

			if(detVarios == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			detVariosList.add(detVarios);
			return new ResponseEntity<List<DetVarios>>(detVariosList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/DetVarios", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createDetVarios(@RequestBody DetVarios detVarios, UriComponentsBuilder uriComponentsBuilder){

		if(detVarios.getCodArt().equals(null)||detVarios.getCodArt().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_detVariosService.getDetVariosByName(detVarios.getCodArt()) != null) {

			return new ResponseEntity("The DetVarios already exist", HttpStatus.CONFLICT);

		}

		_detVariosService.createDetVarios(detVarios);
		DetVarios newDetVarios = _detVariosService.getDetVariosByName(detVarios.getCodArt());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/DetVarios/{id}")
				.buildAndExpand(newDetVarios.getIdDetVarios())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/DetVarios/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<DetVarios> updateDetVarios(@PathVariable("id") Long idDetVarios, @RequestBody DetVarios detVarios){

		if(idDetVarios == null || idDetVarios <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		DetVarios newDetVarios = _detVariosService.getDetVariosById(idDetVarios);
		if(newDetVarios == null) {

			return new ResponseEntity("There's no DetVarios with the id", HttpStatus.CONFLICT);

		}

		newDetVarios.setDescripcion(detVarios.getDescripcion());

		_detVariosService.updateDetVarios(newDetVarios);
		return new ResponseEntity<DetVarios>(newDetVarios, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/DetVarios/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteDetVariosById(@PathVariable("id") Long idDetVarios){

		if(idDetVarios == null || idDetVarios <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		DetVarios detVarios = _detVariosService.getDetVariosById(idDetVarios);
		if(detVarios == null) {

			return new ResponseEntity("Can't remove an inexistent DetVarios", HttpStatus.CONFLICT);
		}

		_detVariosService.removeDetVarios(idDetVarios);
		return new ResponseEntity(HttpStatus.OK);



	}

}
