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
import com.scm.gsoft.domain.cxc.CiaL;
import com.scm.gsoft.service.cxc.CiaLService;

@Controller("CiaLControllerCxc")
@RequestMapping("/v1/cxc")
public class CiaLController {

	@Autowired
	@Qualifier("CiaLServiceCxc")
	private CiaLService _ciaLService;

	//GET
	@RequestMapping(value = "/CiaL/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<CiaL> getCiaLById(@PathVariable("id") Long idCiaL){

		if(idCiaL == null || idCiaL <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		CiaL ciaL = _ciaLService.getCiaLById(idCiaL);
		if(ciaL == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<CiaL>(ciaL, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/CiaL", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<CiaL>> getCiaLByName(@RequestParam(value = "name", required = false) String name){

		List<CiaL> ciaLList = new ArrayList<>();

		if(name == null) {

			ciaLList = _ciaLService.getCiaLList();

			if(ciaLList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<CiaL>>(ciaLList, HttpStatus.OK);

			}

		} else {

			CiaL ciaL = _ciaLService.getCiaLByName(name);

			if(ciaL == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			ciaLList.add(ciaL);
			return new ResponseEntity<List<CiaL>>(ciaLList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/CiaL", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCiaL(@RequestBody CiaL ciaL, UriComponentsBuilder uriComponentsBuilder){

		if(ciaL.getNombre().equals(null)||ciaL.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_ciaLService.getCiaLByName(ciaL.getNombre()) != null) {

			return new ResponseEntity("The CiaL already exist", HttpStatus.CONFLICT);

		}

		_ciaLService.createCiaL(ciaL);
		CiaL newCiaL = _ciaLService.getCiaLByName(ciaL.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/CiaL/{id}")
				.buildAndExpand(newCiaL.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/CiaL/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<CiaL> updateCiaL(@PathVariable("id") Long idCiaL, @RequestBody CiaL ciaL){

		if(idCiaL == null || idCiaL <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		CiaL newCiaL = _ciaLService.getCiaLById(idCiaL);
		if(newCiaL == null) {

			return new ResponseEntity("There's no CiaL with the id", HttpStatus.CONFLICT);

		}
		
		newCiaL.setNombre(ciaL.getNombre());

		_ciaLService.updateCiaL(newCiaL);
		return new ResponseEntity<CiaL>(newCiaL, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/CiaL/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteCiaLById(@PathVariable("id") Long idCiaL){

		if(idCiaL == null || idCiaL <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		CiaL ciaL = _ciaLService.getCiaLById(idCiaL);
		if(ciaL == null) {

			return new ResponseEntity("Can't remove an inexistent CiaL", HttpStatus.CONFLICT);
		}

		_ciaLService.removeCiaL(idCiaL);
		return new ResponseEntity(HttpStatus.OK);



	}

}
