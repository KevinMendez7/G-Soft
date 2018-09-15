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
import com.scm.gsoft.domain.inv.Dolar;
import com.scm.gsoft.service.inv.DolarService;

@Controller
@RequestMapping("/v1/inv")
public class DolarController {

	@Autowired
	private DolarService _dolarService;

	//GET
	@RequestMapping(value = "/Dolar/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Dolar> getDolarById(@PathVariable("id") Long idDolar){

		if(idDolar == null || idDolar <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Dolar dolar = _dolarService.getDolarById(idDolar);
		if(dolar == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Dolar>(dolar, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Dolar", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Dolar>> getDolarByName(@RequestParam(value = "name", required = false) String name){

		List<Dolar> dolarList = new ArrayList<>();

		if(name == null) {

			dolarList = _dolarService.getDolarList();

			if(dolarList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Dolar>>(dolarList, HttpStatus.OK);

			}

		} else {

			Dolar dolar = _dolarService.getDolarByName(name);

			if(dolar == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			dolarList.add(dolar);
			return new ResponseEntity<List<Dolar>>(dolarList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Dolar", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createDolar(@RequestBody Dolar dolar, UriComponentsBuilder uriComponentsBuilder){

		if(dolar.getCampo().equals(null)||dolar.getCampo().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_dolarService.getDolarByName(dolar.getCampo()) != null) {

			return new ResponseEntity("The Dolar already exist", HttpStatus.CONFLICT);

		}

		_dolarService.createDolar(dolar);
		Dolar newDolar = _dolarService.getDolarByName(dolar.getCampo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Dolar/{id}")
				.buildAndExpand(newDolar.getIdDolar())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Dolar/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Dolar> updateDolar(@PathVariable("id") Long idDolar, @RequestBody Dolar dolar){

		if(idDolar == null || idDolar <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Dolar newDolar = _dolarService.getDolarById(idDolar);
		if(newDolar == null) {

			return new ResponseEntity("There's no Dolar with the id", HttpStatus.CONFLICT);

		}

		newDolar.setAgroCompra(dolar.getAgroCompra());		

		_dolarService.updateDolar(newDolar);
		return new ResponseEntity<Dolar>(newDolar, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Dolar/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteDolarById(@PathVariable("id") Long idDolar){

		if(idDolar == null || idDolar <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Dolar dolar = _dolarService.getDolarById(idDolar);
		if(dolar == null) {

			return new ResponseEntity("Can't remove an inexistent Dolar", HttpStatus.CONFLICT);
		}

		_dolarService.removeDolar(idDolar);
		return new ResponseEntity(HttpStatus.OK);



	}

}
