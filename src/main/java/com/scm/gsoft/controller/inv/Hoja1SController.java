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
import com.scm.gsoft.domain.inv.Hoja1S;
import com.scm.gsoft.service.inv.Hoja1SService;

@Controller
@RequestMapping("/v1/inv")
public class Hoja1SController {

	@Autowired
	private Hoja1SService _hoja1SService;

	//GET
	@RequestMapping(value = "/Hoja1S/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Hoja1S> getHoja1SById(@PathVariable("id") Long idHoja1S){

		if(idHoja1S == null || idHoja1S <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Hoja1S hoja1S = _hoja1SService.getHoja1SById(idHoja1S);
		if(hoja1S == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Hoja1S>(hoja1S, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Hoja1S", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Hoja1S>> getHoja1SByName(@RequestParam(value = "name", required = false) String name){

		List<Hoja1S> hoja1SList = new ArrayList<>();

		if(name == null) {

			hoja1SList = _hoja1SService.getHoja1SList();

			if(hoja1SList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Hoja1S>>(hoja1SList, HttpStatus.OK);

			}

		} else {

			Hoja1S hoja1S = _hoja1SService.getHoja1SByName(name);

			if(hoja1S == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			hoja1SList.add(hoja1S);
			return new ResponseEntity<List<Hoja1S>>(hoja1SList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Hoja1S", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createHoja1S(@RequestBody Hoja1S hoja1S, UriComponentsBuilder uriComponentsBuilder){

		if(hoja1S.getAnio().equals(null)||hoja1S.getAnio().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_hoja1SService.getHoja1SByName(hoja1S.getAnio()) != null) {

			return new ResponseEntity("The Hoja1S already exist", HttpStatus.CONFLICT);

		}

		_hoja1SService.createHoja1S(hoja1S);
		Hoja1S newHoja1S = _hoja1SService.getHoja1SByName(hoja1S.getAnio());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Hoja1S/{id}")
				.buildAndExpand(newHoja1S.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Hoja1S/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Hoja1S> updateHoja1S(@PathVariable("id") Long idHoja1S, @RequestBody Hoja1S hoja1S){

		if(idHoja1S == null || idHoja1S <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Hoja1S newHoja1S = _hoja1SService.getHoja1SById(idHoja1S);
		if(newHoja1S == null) {

			return new ResponseEntity("There's no Hoja1S with the id", HttpStatus.CONFLICT);

		}

		newHoja1S.setUsuario(hoja1S.getUsuario());
		newHoja1S.setStatReg(hoja1S.getStatReg());

		_hoja1SService.updateHoja1S(newHoja1S);
		return new ResponseEntity<Hoja1S>(newHoja1S, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Hoja1S/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteHoja1SById(@PathVariable("id") Long idHoja1S){

		if(idHoja1S == null || idHoja1S <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Hoja1S hoja1S = _hoja1SService.getHoja1SById(idHoja1S);
		if(hoja1S == null) {

			return new ResponseEntity("Can't remove an inexistent Hoja1S", HttpStatus.CONFLICT);
		}

		_hoja1SService.removeHoja1S(idHoja1S);
		return new ResponseEntity(HttpStatus.OK);



	}

}
