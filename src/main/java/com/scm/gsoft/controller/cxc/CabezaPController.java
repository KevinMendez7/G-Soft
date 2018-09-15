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
import com.scm.gsoft.domain.cxc.CabezaP;
import com.scm.gsoft.service.cxc.CabezaPService;

@Controller
@RequestMapping("/v1/cxc")
public class CabezaPController {

	@Autowired
	private CabezaPService _cabezaPService;

	//GET
	@RequestMapping(value = "/CabezaP/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<CabezaP> getCabezaPById(@PathVariable("id") Long idCabezaP){

		if(idCabezaP == null || idCabezaP <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		CabezaP cabezaP = _cabezaPService.getCabezaPById(idCabezaP);
		if(cabezaP == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<CabezaP>(cabezaP, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/CabezaP", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<CabezaP>> getCabezaPByName(@RequestParam(value = "name", required = false) String name){

		List<CabezaP> cabezaPList = new ArrayList<>();

		if(name == null) {

			cabezaPList = _cabezaPService.getCabezaPList();

			if(cabezaPList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<CabezaP>>(cabezaPList, HttpStatus.OK);

			}

		} else {

			CabezaP cabezaP = _cabezaPService.getCabezaPByName(name);

			if(cabezaP == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			cabezaPList.add(cabezaP);
			return new ResponseEntity<List<CabezaP>>(cabezaPList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/CabezaP", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCabezaP(@RequestBody CabezaP cabezaP, UriComponentsBuilder uriComponentsBuilder){

		if(cabezaP.getPoliza().equals(null)||cabezaP.getPoliza().isEmpty()) {

			return new ResponseEntity("Poliza can't be null", HttpStatus.CONFLICT);

		}

		if(_cabezaPService.getCabezaPByName(cabezaP.getPoliza()) != null) {

			return new ResponseEntity("The CabezaP already exist", HttpStatus.CONFLICT);

		}

		_cabezaPService.createCabezaP(cabezaP);
		CabezaP newCabezaP = _cabezaPService.getCabezaPByName(cabezaP.getPoliza());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/CabezaP/{id}")
				.buildAndExpand(newCabezaP.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/CabezaP/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<CabezaP> updateCabezaP(@PathVariable("id") Long idCabezaP, @RequestBody CabezaP cabezaP){

		if(idCabezaP == null || idCabezaP <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		CabezaP newCabezaP = _cabezaPService.getCabezaPById(idCabezaP);
		if(newCabezaP == null) {

			return new ResponseEntity("There's no CabezaP with the id", HttpStatus.CONFLICT);

		}

		newCabezaP.setCosto(cabezaP.getCosto());
		

		_cabezaPService.updateCabezaP(newCabezaP);
		return new ResponseEntity<CabezaP>(newCabezaP, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/CabezaP/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteCabezaPById(@PathVariable("id") Long idCabezaP){

		if(idCabezaP == null || idCabezaP <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		CabezaP cabezaP = _cabezaPService.getCabezaPById(idCabezaP);
		if(cabezaP == null) {

			return new ResponseEntity("Can't remove an inexistent CabezaP", HttpStatus.CONFLICT);
		}

		_cabezaPService.removeCabezaP(idCabezaP);
		return new ResponseEntity(HttpStatus.OK);



	}

}
