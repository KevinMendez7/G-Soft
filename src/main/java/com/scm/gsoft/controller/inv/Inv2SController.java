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
import com.scm.gsoft.domain.inv.Inv2S;
import com.scm.gsoft.service.inv.Inv2SService;

@Controller
@RequestMapping("/v1/inv")
public class Inv2SController {

	@Autowired
	private Inv2SService _inv2SService;

	//GET
	@RequestMapping(value = "/Inv2S/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Inv2S> getInv2SById(@PathVariable("id") Long idInv2S){

		if(idInv2S == null || idInv2S <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Inv2S inv2S = _inv2SService.getInv2SById(idInv2S);
		if(inv2S == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Inv2S>(inv2S, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Inv2S", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Inv2S>> getInv2SByName(@RequestParam(value = "name", required = false) String name){

		List<Inv2S> inv2SList = new ArrayList<>();

		if(name == null) {

			inv2SList = _inv2SService.getInv2SList();

			if(inv2SList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Inv2S>>(inv2SList, HttpStatus.OK);

			}

		} else {

			Inv2S inv2S = _inv2SService.getInv2SByName(name);

			if(inv2S == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			inv2SList.add(inv2S);
			return new ResponseEntity<List<Inv2S>>(inv2SList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Inv2S", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createInv2S(@RequestBody Inv2S inv2S, UriComponentsBuilder uriComponentsBuilder){

		if(inv2S.getAnio().equals(null)||inv2S.getAnio().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_inv2SService.getInv2SByName(inv2S.getAnio()) != null) {

			return new ResponseEntity("The Inv2S already exist", HttpStatus.CONFLICT);

		}

		_inv2SService.createInv2S(inv2S);
		Inv2S newInv2S = _inv2SService.getInv2SByName(inv2S.getAnio());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Inv2S/{id}")
				.buildAndExpand(newInv2S.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Inv2S/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Inv2S> updateInv2S(@PathVariable("id") Long idInv2S, @RequestBody Inv2S inv2S){

		if(idInv2S == null || idInv2S <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Inv2S newInv2S = _inv2SService.getInv2SById(idInv2S);
		if(newInv2S == null) {

			return new ResponseEntity("There's no Inv2S with the id", HttpStatus.CONFLICT);

		}

		newInv2S.setUsuario(inv2S.getUsuario());
		newInv2S.setStatReg(inv2S.getStatReg());

		_inv2SService.updateInv2S(newInv2S);
		return new ResponseEntity<Inv2S>(newInv2S, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Inv2S/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteInv2SById(@PathVariable("id") Long idInv2S){

		if(idInv2S == null || idInv2S <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Inv2S inv2S = _inv2SService.getInv2SById(idInv2S);
		if(inv2S == null) {

			return new ResponseEntity("Can't remove an inexistent Inv2S", HttpStatus.CONFLICT);
		}

		_inv2SService.removeInv2S(idInv2S);
		return new ResponseEntity(HttpStatus.OK);



	}

}
