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
import com.scm.gsoft.domain.cxc.Correlativo;
import com.scm.gsoft.service.cxc.CorrelativoService;

@Controller
@RequestMapping("/v1/cxc")
public class CorrelativoController {

	@Autowired
	private CorrelativoService _correlativoService;

	//GET
	@RequestMapping(value = "/Correlativo/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Correlativo> getCorrelativoById(@PathVariable("id") Long idCorrelativo){

		if(idCorrelativo == null || idCorrelativo <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Correlativo correlativo = _correlativoService.getCorrelativoById(idCorrelativo);
		if(correlativo == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Correlativo>(correlativo, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Correlativo", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Correlativo>> getCorrelativoByName(@RequestParam(value = "name", required = false) String name){

		List<Correlativo> correlativoList = new ArrayList<>();

		if(name == null) {

			correlativoList = _correlativoService.getCorrelativoList();

			if(correlativoList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Correlativo>>(correlativoList, HttpStatus.OK);

			}

		} else {

			Correlativo correlativo = _correlativoService.getCorrelativoByName(name);

			if(correlativo == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			correlativoList.add(correlativo);
			return new ResponseEntity<List<Correlativo>>(correlativoList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Correlativo", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCorrelativo(@RequestBody Correlativo correlativo, UriComponentsBuilder uriComponentsBuilder){

		if(correlativo.getCorr().equals(null)||correlativo.getCorr().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_correlativoService.getCorrelativoByName(correlativo.getCorr()) != null) {

			return new ResponseEntity("The Correlativo already exist", HttpStatus.CONFLICT);

		}

		_correlativoService.createCorrelativo(correlativo);
		Correlativo newCorrelativo = _correlativoService.getCorrelativoByName(correlativo.getCorr());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Correlativo/{id}")
				.buildAndExpand(newCorrelativo.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Correlativo/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Correlativo> updateCorrelativo(@PathVariable("id") Long idCorrelativo, @RequestBody Correlativo correlativo){

		if(idCorrelativo == null || idCorrelativo <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Correlativo newCorrelativo = _correlativoService.getCorrelativoById(idCorrelativo);
		if(newCorrelativo == null) {

			return new ResponseEntity("There's no Correlativo with the id", HttpStatus.CONFLICT);

		}

		newCorrelativo.setCodigo(correlativo.getCodigo());		
		newCorrelativo.setStatReg(correlativo.getStatReg());

		_correlativoService.updateCorrelativo(newCorrelativo);
		return new ResponseEntity<Correlativo>(newCorrelativo, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Correlativo/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteCorrelativoById(@PathVariable("id") Long idCorrelativo){

		if(idCorrelativo == null || idCorrelativo <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Correlativo correlativo = _correlativoService.getCorrelativoById(idCorrelativo);
		if(correlativo == null) {

			return new ResponseEntity("Can't remove an inexistent Correlativo", HttpStatus.CONFLICT);
		}

		_correlativoService.removeCorrelativo(idCorrelativo);
		return new ResponseEntity(HttpStatus.OK);



	}

}
