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
import com.scm.gsoft.domain.inv.MaebodPrecios;
import com.scm.gsoft.service.inv.MaebodPreciosService;

@Controller
@RequestMapping("/v1/inv")
public class MaebodPreciosController {

	@Autowired
	private MaebodPreciosService _maebodPreciosService;

	//GET
	@RequestMapping(value = "/MaebodPrecios/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<MaebodPrecios> getMaebodPreciosById(@PathVariable("id") Long idMaebodPrecios){

		if(idMaebodPrecios == null || idMaebodPrecios <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		MaebodPrecios maebodPrecios = _maebodPreciosService.getMaebodPreciosById(idMaebodPrecios);
		if(maebodPrecios == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<MaebodPrecios>(maebodPrecios, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/MaebodPrecios", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<MaebodPrecios>> getMaebodPreciosByName(@RequestParam(value = "name", required = false) String name){

		List<MaebodPrecios> maebodPreciosList = new ArrayList<>();

		if(name == null) {

			maebodPreciosList = _maebodPreciosService.getMaebodPreciosList();

			if(maebodPreciosList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<MaebodPrecios>>(maebodPreciosList, HttpStatus.OK);

			}

		} else {

			MaebodPrecios maebodPrecios = _maebodPreciosService.getMaebodPreciosByName(name);

			if(maebodPrecios == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			maebodPreciosList.add(maebodPrecios);
			return new ResponseEntity<List<MaebodPrecios>>(maebodPreciosList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/MaebodPrecios", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createMaebodPrecios(@RequestBody MaebodPrecios maebodPrecios, UriComponentsBuilder uriComponentsBuilder){

		if(maebodPrecios.getAnio().equals(null)||maebodPrecios.getAnio().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_maebodPreciosService.getMaebodPreciosByName(maebodPrecios.getAnio()) != null) {

			return new ResponseEntity("The MaebodPrecios already exist", HttpStatus.CONFLICT);

		}

		_maebodPreciosService.createMaebodPrecios(maebodPrecios);
		MaebodPrecios newMaebodPrecios = _maebodPreciosService.getMaebodPreciosByName(maebodPrecios.getAnio());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/MaebodPrecios/{id}")
				.buildAndExpand(newMaebodPrecios.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/MaebodPrecios/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<MaebodPrecios> updateMaebodPrecios(@PathVariable("id") Long idMaebodPrecios, @RequestBody MaebodPrecios maebodPrecios){

		if(idMaebodPrecios == null || idMaebodPrecios <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		MaebodPrecios newMaebodPrecios = _maebodPreciosService.getMaebodPreciosById(idMaebodPrecios);
		if(newMaebodPrecios == null) {

			return new ResponseEntity("There's no MaebodPrecios with the id", HttpStatus.CONFLICT);

		}

		newMaebodPrecios.setUsuario(maebodPrecios.getUsuario());
		newMaebodPrecios.setStatReg(maebodPrecios.getStatReg());

		_maebodPreciosService.updateMaebodPrecios(newMaebodPrecios);
		return new ResponseEntity<MaebodPrecios>(newMaebodPrecios, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/MaebodPrecios/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteMaebodPreciosById(@PathVariable("id") Long idMaebodPrecios){

		if(idMaebodPrecios == null || idMaebodPrecios <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		MaebodPrecios maebodPrecios = _maebodPreciosService.getMaebodPreciosById(idMaebodPrecios);
		if(maebodPrecios == null) {

			return new ResponseEntity("Can't remove an inexistent MaebodPrecios", HttpStatus.CONFLICT);
		}

		_maebodPreciosService.removeMaebodPrecios(idMaebodPrecios);
		return new ResponseEntity(HttpStatus.OK);



	}

}
