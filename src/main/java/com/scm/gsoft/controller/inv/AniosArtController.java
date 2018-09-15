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
import com.scm.gsoft.domain.inv.AniosArt;
import com.scm.gsoft.service.inv.AniosArtService;

@Controller
@RequestMapping("/v1/cxc")
public class AniosArtController {

	@Autowired
	private AniosArtService _aniosArtService;

	//GET
	@RequestMapping(value = "/AniosArt/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<AniosArt> getAniosArtById(@PathVariable("id") Long idAniosArt){

		if(idAniosArt == null || idAniosArt <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		AniosArt aniosArt = _aniosArtService.getAniosArtById(idAniosArt);
		if(aniosArt == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<AniosArt>(aniosArt, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/AniosArt", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<AniosArt>> getAniosArtByName(@RequestParam(value = "name", required = false) String name){

		List<AniosArt> aniosArtList = new ArrayList<>();

		if(name == null) {

			aniosArtList = _aniosArtService.getAniosArtList();

			if(aniosArtList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<AniosArt>>(aniosArtList, HttpStatus.OK);

			}

		} else {

			AniosArt aniosArt = _aniosArtService.getAniosArtByName(name);

			if(aniosArt == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			aniosArtList.add(aniosArt);
			return new ResponseEntity<List<AniosArt>>(aniosArtList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/AniosArt", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createAniosArt(@RequestBody AniosArt aniosArt, UriComponentsBuilder uriComponentsBuilder){

		if(aniosArt.getAnios().equals(null)||aniosArt.getAnios().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_aniosArtService.getAniosArtByName(aniosArt.getAnios()) != null) {

			return new ResponseEntity("The AniosArt already exist", HttpStatus.CONFLICT);

		}

		_aniosArtService.createAniosArt(aniosArt);
		AniosArt newAniosArt = _aniosArtService.getAniosArtByName(aniosArt.getAnios());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/AniosArt/{id}")
				.buildAndExpand(newAniosArt.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/AniosArt/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<AniosArt> updateAniosArt(@PathVariable("id") Long idAniosArt, @RequestBody AniosArt aniosArt){

		if(idAniosArt == null || idAniosArt <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		AniosArt newAniosArt = _aniosArtService.getAniosArtById(idAniosArt);
		if(newAniosArt == null) {

			return new ResponseEntity("There's no AniosArt with the id", HttpStatus.CONFLICT);

		}
		
		newAniosArt.setUsuario(aniosArt.getUsuario());
		newAniosArt.setStatReg(aniosArt.getStatReg());

		_aniosArtService.updateAniosArt(newAniosArt);
		return new ResponseEntity<AniosArt>(newAniosArt, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/AniosArt/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteAniosArtById(@PathVariable("id") Long idAniosArt){

		if(idAniosArt == null || idAniosArt <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		AniosArt aniosArt = _aniosArtService.getAniosArtById(idAniosArt);
		if(aniosArt == null) {

			return new ResponseEntity("Can't remove an inexistent AniosArt", HttpStatus.CONFLICT);
		}

		_aniosArtService.removeAniosArt(idAniosArt);
		return new ResponseEntity(HttpStatus.OK);



	}

}
