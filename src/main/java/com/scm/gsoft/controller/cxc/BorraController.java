package com.scm.gsoft.controller.cxc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.scm.gsoft.domain.cxc.Borra;
import com.scm.gsoft.service.cxc.BorraService;

@Controller("BorraControllerCxc")
@RequestMapping("/v1/cxc")
public class BorraController {

	@Autowired
	@Qualifier("BorraServiceCxc")
	private BorraService _borraService;

	//GET
	@RequestMapping(value = "/Borra/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Borra> getBorraById(@PathVariable("id") Long idBorra){

		if(idBorra == null || idBorra <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Borra borra = _borraService.getBorraById(idBorra);
		if(borra == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Borra>(borra, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Borra", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Borra>> getBorraByCodeBodega(@RequestParam(value = "codeBodega", required = false) String codeBodega){

		List<Borra> borraList = new ArrayList<>();

		if(codeBodega == null) {

			borraList = _borraService.getBorraList();

			if(borraList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Borra>>(borraList, HttpStatus.OK);

			}

		} else {

			Borra borra = _borraService.getBorraByCodeBodega(codeBodega);

			if(borra == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			borraList.add(borra);
			return new ResponseEntity<List<Borra>>(borraList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Borra", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createBorra(@RequestBody Borra borra, UriComponentsBuilder uriComponentsBuilder){

		if(borra.getBodega().equals(null)||borra.getBodega().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_borraService.getBorraByCodeBodega(borra.getBodega()) != null) {

			return new ResponseEntity("The Borra already exist", HttpStatus.CONFLICT);

		}

		_borraService.createBorra(borra);
		Borra newBorra = _borraService.getBorraByCodeBodega(borra.getBodega());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Borra/{id}")
				.buildAndExpand(newBorra.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Borra/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Borra> updateBorra(@PathVariable("id") Long idBorra, @RequestBody Borra borra){

		if(idBorra == null || idBorra <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Borra newBorra = _borraService.getBorraById(idBorra);
		if(newBorra == null) {

			return new ResponseEntity("There's no Borra with the id", HttpStatus.CONFLICT);

		}
		
		newBorra.setBodega(borra.getBodega());		

		_borraService.updateBorra(newBorra);
		return new ResponseEntity<Borra>(newBorra, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Borra/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteBorraById(@PathVariable("id") Long idBorra){

		if(idBorra == null || idBorra <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Borra borra = _borraService.getBorraById(idBorra);
		if(borra == null) {

			return new ResponseEntity("Can't remove an inexistent Borra", HttpStatus.CONFLICT);
		}

		_borraService.removeBorra(idBorra);
		return new ResponseEntity(HttpStatus.OK);



	}

}
