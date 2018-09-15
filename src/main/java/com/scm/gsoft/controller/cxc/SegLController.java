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
import com.scm.gsoft.domain.cxc.SegL;
import com.scm.gsoft.service.cxc.SegLService;

@Controller
@RequestMapping("/v1/cxc")
public class SegLController {

	@Autowired
	private SegLService _segLService;

	//GET
	@RequestMapping(value = "/SegL/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<SegL> getSegLById(@PathVariable("id") Long idSegL){

		if(idSegL == null || idSegL <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		SegL segL = _segLService.getSegLById(idSegL);
		if(segL == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<SegL>(segL, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/SegL", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<SegL>> getSegLByName(@RequestParam(value = "name", required = false) String name){

		List<SegL> segLList = new ArrayList<>();

		if(name == null) {

			segLList = _segLService.getSegLList();

			if(segLList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<SegL>>(segLList, HttpStatus.OK);

			}

		} else {

			SegL segL = _segLService.getSegLByName(name);

			if(segL == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			segLList.add(segL);
			return new ResponseEntity<List<SegL>>(segLList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/SegL", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createSegL(@RequestBody SegL segL, UriComponentsBuilder uriComponentsBuilder){

		if(segL.getNombre().equals(null)||segL.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_segLService.getSegLByName(segL.getNombre()) != null) {

			return new ResponseEntity("The SegL already exist", HttpStatus.CONFLICT);

		}

		_segLService.createSegL(segL);
		SegL newSegL = _segLService.getSegLByName(segL.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/SegL/{id}")
				.buildAndExpand(newSegL.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/SegL/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<SegL> updateSegL(@PathVariable("id") Long idSegL, @RequestBody SegL segL){

		if(idSegL == null || idSegL <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		SegL newSegL = _segLService.getSegLById(idSegL);
		if(newSegL == null) {

			return new ResponseEntity("There's no SegL with the id", HttpStatus.CONFLICT);

		}
		
		newSegL.setNombre(segL.getNombre());
		newSegL.setUsuario(segL.getUsuario());

		_segLService.updateSegL(newSegL);
		return new ResponseEntity<SegL>(newSegL, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/SegL/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteSegLById(@PathVariable("id") Long idSegL){

		if(idSegL == null || idSegL <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		SegL segL = _segLService.getSegLById(idSegL);
		if(segL == null) {

			return new ResponseEntity("Can't remove an inexistent SegL", HttpStatus.CONFLICT);
		}

		_segLService.removeSegL(idSegL);
		return new ResponseEntity(HttpStatus.OK);



	}

}
