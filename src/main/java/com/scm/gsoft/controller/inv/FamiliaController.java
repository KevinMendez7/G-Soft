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
import com.scm.gsoft.domain.inv.Familia;
import com.scm.gsoft.service.inv.FamiliaService;

@Controller
@RequestMapping("/v1/inv")
public class FamiliaController {

	@Autowired
	private FamiliaService _familiaService;

	//GET
	@RequestMapping(value = "/Familia/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Familia> getFamiliaById(@PathVariable("id") Long idFamilia){

		if(idFamilia == null || idFamilia <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Familia familia = _familiaService.getFamiliaById(idFamilia);
		if(familia == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Familia>(familia, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Familia", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Familia>> getFamiliaByName(@RequestParam(value = "name", required = false) String name){

		List<Familia> familiaList = new ArrayList<>();

		if(name == null) {

			familiaList = _familiaService.getFamiliaList();

			if(familiaList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Familia>>(familiaList, HttpStatus.OK);

			}

		} else {

			Familia familia = _familiaService.getFamiliaByName(name);

			if(familia == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			familiaList.add(familia);
			return new ResponseEntity<List<Familia>>(familiaList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Familia", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createFamilia(@RequestBody Familia familia, UriComponentsBuilder uriComponentsBuilder){

		if(familia.getCodFamilia().equals(null)||familia.getCodFamilia().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_familiaService.getFamiliaByName(familia.getCodFamilia()) != null) {

			return new ResponseEntity("The Familia already exist", HttpStatus.CONFLICT);

		}

		_familiaService.createFamilia(familia);
		Familia newFamilia = _familiaService.getFamiliaByName(familia.getCodFamilia());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Familia/{id}")
				.buildAndExpand(newFamilia.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Familia/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Familia> updateFamilia(@PathVariable("id") Long idFamilia, @RequestBody Familia familia){

		if(idFamilia == null || idFamilia <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Familia newFamilia = _familiaService.getFamiliaById(idFamilia);
		if(newFamilia == null) {

			return new ResponseEntity("There's no Familia with the id", HttpStatus.CONFLICT);

		}

		newFamilia.setUsuario(familia.getUsuario());
		newFamilia.setStatReg(familia.getStatReg());

		_familiaService.updateFamilia(newFamilia);
		return new ResponseEntity<Familia>(newFamilia, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Familia/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteFamiliaById(@PathVariable("id") Long idFamilia){

		if(idFamilia == null || idFamilia <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Familia familia = _familiaService.getFamiliaById(idFamilia);
		if(familia == null) {

			return new ResponseEntity("Can't remove an inexistent Familia", HttpStatus.CONFLICT);
		}

		_familiaService.removeFamilia(idFamilia);
		return new ResponseEntity(HttpStatus.OK);



	}

}
