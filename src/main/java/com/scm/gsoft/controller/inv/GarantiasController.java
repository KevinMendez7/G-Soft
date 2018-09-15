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
import com.scm.gsoft.domain.inv.Garantias;
import com.scm.gsoft.service.inv.GarantiasService;

@Controller
@RequestMapping("/v1/inv")
public class GarantiasController {

	@Autowired
	private GarantiasService _garantiasService;

	//GET
	@RequestMapping(value = "/Garantias/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Garantias> getGarantiasById(@PathVariable("id") Long idGarantias){

		if(idGarantias == null || idGarantias <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Garantias garantias = _garantiasService.getGarantiasById(idGarantias);
		if(garantias == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Garantias>(garantias, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Garantias", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Garantias>> getGarantiasByName(@RequestParam(value = "name", required = false) String name){

		List<Garantias> garantiasList = new ArrayList<>();

		if(name == null) {

			garantiasList = _garantiasService.getGarantiasList();

			if(garantiasList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Garantias>>(garantiasList, HttpStatus.OK);

			}

		} else {

			Garantias garantias = _garantiasService.getGarantiasByName(name);

			if(garantias == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			garantiasList.add(garantias);
			return new ResponseEntity<List<Garantias>>(garantiasList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Garantias", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createGarantias(@RequestBody Garantias garantias, UriComponentsBuilder uriComponentsBuilder){

		if(garantias.getTiempo().equals(null)||garantias.getTiempo().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_garantiasService.getGarantiasByName(garantias.getTiempo()) != null) {

			return new ResponseEntity("The Garantias already exist", HttpStatus.CONFLICT);

		}

		_garantiasService.createGarantias(garantias);
		Garantias newGarantias = _garantiasService.getGarantiasByName(garantias.getTiempo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Garantias/{id}")
				.buildAndExpand(newGarantias.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Garantias/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Garantias> updateGarantias(@PathVariable("id") Long idGarantias, @RequestBody Garantias garantias){

		if(idGarantias == null || idGarantias <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Garantias newGarantias = _garantiasService.getGarantiasById(idGarantias);
		if(newGarantias == null) {

			return new ResponseEntity("There's no Garantias with the id", HttpStatus.CONFLICT);

		}

		newGarantias.setUsuario(garantias.getUsuario());
		newGarantias.setStatReg(garantias.getStatReg());

		_garantiasService.updateGarantias(newGarantias);
		return new ResponseEntity<Garantias>(newGarantias, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Garantias/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteGarantiasById(@PathVariable("id") Long idGarantias){

		if(idGarantias == null || idGarantias <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Garantias garantias = _garantiasService.getGarantiasById(idGarantias);
		if(garantias == null) {

			return new ResponseEntity("Can't remove an inexistent Garantias", HttpStatus.CONFLICT);
		}

		_garantiasService.removeGarantias(idGarantias);
		return new ResponseEntity(HttpStatus.OK);



	}

}
