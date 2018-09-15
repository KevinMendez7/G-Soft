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
import com.scm.gsoft.domain.cxc.DctosPl;
import com.scm.gsoft.service.cxc.DctosPlService;

@Controller
@RequestMapping("/v1/cxc")
public class DctosPlController {

	@Autowired
	private DctosPlService _dctosPlService;

	//GET
	@RequestMapping(value = "/DctosPl/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<DctosPl> getDctosPlById(@PathVariable("id") Long idDctosPl){

		if(idDctosPl == null || idDctosPl <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		DctosPl dctosPl = _dctosPlService.getDctosPlById(idDctosPl);
		if(dctosPl == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<DctosPl>(dctosPl, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/DctosPl", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<DctosPl>> getDctosPlByName(@RequestParam(value = "name", required = false) String name){

		List<DctosPl> dctosPlList = new ArrayList<>();

		if(name == null) {

			dctosPlList = _dctosPlService.getDctosPlList();

			if(dctosPlList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<DctosPl>>(dctosPlList, HttpStatus.OK);

			}

		} else {

			DctosPl dctosPl = _dctosPlService.getDctosPlByName(name);

			if(dctosPl == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			dctosPlList.add(dctosPl);
			return new ResponseEntity<List<DctosPl>>(dctosPlList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/DctosPl", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createDctosPl(@RequestBody DctosPl dctosPl, UriComponentsBuilder uriComponentsBuilder){

		if(dctosPl.getCodigo().equals(null)||dctosPl.getCodigo().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_dctosPlService.getDctosPlByName(dctosPl.getCodigo()) != null) {

			return new ResponseEntity("The DctosPl already exist", HttpStatus.CONFLICT);

		}

		_dctosPlService.createDctosPl(dctosPl);
		DctosPl newDctosPl = _dctosPlService.getDctosPlByName(dctosPl.getCodigo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/DctosPl/{id}")
				.buildAndExpand(newDctosPl.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/DctosPl/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<DctosPl> updateDctosPl(@PathVariable("id") Long idDctosPl, @RequestBody DctosPl dctosPl){

		if(idDctosPl == null || idDctosPl <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		DctosPl newDctosPl = _dctosPlService.getDctosPlById(idDctosPl);
		if(newDctosPl == null) {

			return new ResponseEntity("There's no DctosPl with the id", HttpStatus.CONFLICT);

		}

		newDctosPl.setCodigo(dctosPl.getCodigo());		
		newDctosPl.setUsuario(dctosPl.getUsuario());
		newDctosPl.setStatReg(dctosPl.getStatReg());

		_dctosPlService.updateDctosPl(newDctosPl);
		return new ResponseEntity<DctosPl>(newDctosPl, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/DctosPl/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteDctosPlById(@PathVariable("id") Long idDctosPl){

		if(idDctosPl == null || idDctosPl <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		DctosPl dctosPl = _dctosPlService.getDctosPlById(idDctosPl);
		if(dctosPl == null) {

			return new ResponseEntity("Can't remove an inexistent DctosPl", HttpStatus.CONFLICT);
		}

		_dctosPlService.removeDctosPl(idDctosPl);
		return new ResponseEntity(HttpStatus.OK);



	}

}
