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
import com.scm.gsoft.domain.cxc.MesL;
import com.scm.gsoft.service.cxc.MesLService;

@Controller
@RequestMapping("/v1/cxc")
public class MesLController {

	@Autowired
	private MesLService _mesLService;

	//GET
	@RequestMapping(value = "/MesL/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<MesL> getMesLById(@PathVariable("id") Long idMesL){

		if(idMesL == null || idMesL <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		MesL mesL = _mesLService.getMesLById(idMesL);
		if(mesL == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<MesL>(mesL, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/MesL", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<MesL>> getMesLByName(@RequestParam(value = "name", required = false) String name){

		List<MesL> mesLList = new ArrayList<>();

		if(name == null) {

			mesLList = _mesLService.getMesLList();

			if(mesLList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<MesL>>(mesLList, HttpStatus.OK);

			}

		} else {

			MesL mesL = _mesLService.getMesLByName(name);

			if(mesL == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			mesLList.add(mesL);
			return new ResponseEntity<List<MesL>>(mesLList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/MesL", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createMesL(@RequestBody MesL mesL, UriComponentsBuilder uriComponentsBuilder){

		if(mesL.getNombre().equals(null)||mesL.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_mesLService.getMesLByName(mesL.getNombre()) != null) {

			return new ResponseEntity("The MesL already exist", HttpStatus.CONFLICT);

		}

		_mesLService.createMesL(mesL);
		MesL newMesL = _mesLService.getMesLByName(mesL.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/MesL/{id}")
				.buildAndExpand(newMesL.getIdMesL())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/MesL/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<MesL> updateMesL(@PathVariable("id") Long idMesL, @RequestBody MesL mesL){

		if(idMesL == null || idMesL <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		MesL newMesL = _mesLService.getMesLById(idMesL);
		if(newMesL == null) {

			return new ResponseEntity("There's no MesL with the id", HttpStatus.CONFLICT);

		}

		newMesL.setNombre(mesL.getNombre());

		_mesLService.updateMesL(newMesL);
		return new ResponseEntity<MesL>(newMesL, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/MesL/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteMesLById(@PathVariable("id") Long idMesL){

		if(idMesL == null || idMesL <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		MesL mesL = _mesLService.getMesLById(idMesL);
		if(mesL == null) {

			return new ResponseEntity("Can't remove an inexistent MesL", HttpStatus.CONFLICT);
		}

		_mesLService.removeMesL(idMesL);
		return new ResponseEntity(HttpStatus.OK);



	}

}
