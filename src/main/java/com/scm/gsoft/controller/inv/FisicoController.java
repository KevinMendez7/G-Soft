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
import com.scm.gsoft.domain.inv.Fisico;
import com.scm.gsoft.service.inv.FisicoService;

@Controller
@RequestMapping("/v1/inv")
public class FisicoController {

	@Autowired
	private FisicoService _fisicoService;

	//GET
	@RequestMapping(value = "/Fisico/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Fisico> getFisicoById(@PathVariable("id") Long idFisico){

		if(idFisico == null || idFisico <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Fisico fisico = _fisicoService.getFisicoById(idFisico);
		if(fisico == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Fisico>(fisico, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Fisico", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Fisico>> getFisicoByName(@RequestParam(value = "name", required = false) String name){

		List<Fisico> fisicoList = new ArrayList<>();

		if(name == null) {

			fisicoList = _fisicoService.getFisicoList();

			if(fisicoList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Fisico>>(fisicoList, HttpStatus.OK);

			}

		} else {

			Fisico fisico = _fisicoService.getFisicoByName(name);

			if(fisico == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			fisicoList.add(fisico);
			return new ResponseEntity<List<Fisico>>(fisicoList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Fisico", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createFisico(@RequestBody Fisico fisico, UriComponentsBuilder uriComponentsBuilder){

		if(fisico.getBodega().equals(null)||fisico.getBodega().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_fisicoService.getFisicoByName(fisico.getBodega()) != null) {

			return new ResponseEntity("The Fisico already exist", HttpStatus.CONFLICT);

		}

		_fisicoService.createFisico(fisico);
		Fisico newFisico = _fisicoService.getFisicoByName(fisico.getBodega());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Fisico/{id}")
				.buildAndExpand(newFisico.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Fisico/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Fisico> updateFisico(@PathVariable("id") Long idFisico, @RequestBody Fisico fisico){

		if(idFisico == null || idFisico <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Fisico newFisico = _fisicoService.getFisicoById(idFisico);
		if(newFisico == null) {

			return new ResponseEntity("There's no Fisico with the id", HttpStatus.CONFLICT);

		}

		newFisico.setBodega(fisico.getBodega());

		_fisicoService.updateFisico(newFisico);
		return new ResponseEntity<Fisico>(newFisico, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Fisico/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteFisicoById(@PathVariable("id") Long idFisico){

		if(idFisico == null || idFisico <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Fisico fisico = _fisicoService.getFisicoById(idFisico);
		if(fisico == null) {

			return new ResponseEntity("Can't remove an inexistent Fisico", HttpStatus.CONFLICT);
		}

		_fisicoService.removeFisico(idFisico);
		return new ResponseEntity(HttpStatus.OK);



	}

}
