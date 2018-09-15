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
import com.scm.gsoft.domain.inv.MovD;
import com.scm.gsoft.service.inv.MovDService;

@Controller
@RequestMapping("/v1/inv")
public class MovDController {

	@Autowired
	private MovDService _movDService;

	//GET
	@RequestMapping(value = "/MovD/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<MovD> getMovDById(@PathVariable("id") Long idMovD){

		if(idMovD == null || idMovD <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		MovD movD = _movDService.getMovDById(idMovD);
		if(movD == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<MovD>(movD, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/MovD", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<MovD>> getMovDByName(@RequestParam(value = "name", required = false) String name){

		List<MovD> movDList = new ArrayList<>();

		if(name == null) {

			movDList = _movDService.getMovDList();

			if(movDList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<MovD>>(movDList, HttpStatus.OK);

			}

		} else {

			MovD movD = _movDService.getMovDByName(name);

			if(movD == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			movDList.add(movD);
			return new ResponseEntity<List<MovD>>(movDList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/MovD", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createMovD(@RequestBody MovD movD, UriComponentsBuilder uriComponentsBuilder){

		if(movD.getNombre().equals(null)||movD.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_movDService.getMovDByName(movD.getNombre()) != null) {

			return new ResponseEntity("The MovD already exist", HttpStatus.CONFLICT);

		}

		_movDService.createMovD(movD);
		MovD newMovD = _movDService.getMovDByName(movD.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/MovD/{id}")
				.buildAndExpand(newMovD.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/MovD/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<MovD> updateMovD(@PathVariable("id") Long idMovD, @RequestBody MovD movD){

		if(idMovD == null || idMovD <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		MovD newMovD = _movDService.getMovDById(idMovD);
		if(newMovD == null) {

			return new ResponseEntity("There's no MovD with the id", HttpStatus.CONFLICT);

		}

		newMovD.setNombre(movD.getNombre());

		_movDService.updateMovD(newMovD);
		return new ResponseEntity<MovD>(newMovD, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/MovD/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteMovDById(@PathVariable("id") Long idMovD){

		if(idMovD == null || idMovD <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		MovD movD = _movDService.getMovDById(idMovD);
		if(movD == null) {

			return new ResponseEntity("Can't remove an inexistent MovD", HttpStatus.CONFLICT);
		}

		_movDService.removeMovD(idMovD);
		return new ResponseEntity(HttpStatus.OK);



	}

}
