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
import com.scm.gsoft.domain.inv.Mecanismo;
import com.scm.gsoft.service.inv.MecanismoService;

@Controller
@RequestMapping("/v1/inv")
public class MecanismoController {

	@Autowired
	private MecanismoService _mecanismoService;

	//GET
	@RequestMapping(value = "/Mecanismo/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Mecanismo> getMecanismoById(@PathVariable("id") Long idMecanismo){

		if(idMecanismo == null || idMecanismo <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Mecanismo mecanismo = _mecanismoService.getMecanismoById(idMecanismo);
		if(mecanismo == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Mecanismo>(mecanismo, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Mecanismo", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Mecanismo>> getMecanismoByName(@RequestParam(value = "name", required = false) String name){

		List<Mecanismo> mecanismoList = new ArrayList<>();

		if(name == null) {

			mecanismoList = _mecanismoService.getMecanismoList();

			if(mecanismoList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Mecanismo>>(mecanismoList, HttpStatus.OK);

			}

		} else {

			Mecanismo mecanismo = _mecanismoService.getMecanismoByName(name);

			if(mecanismo == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			mecanismoList.add(mecanismo);
			return new ResponseEntity<List<Mecanismo>>(mecanismoList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Mecanismo", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createMecanismo(@RequestBody Mecanismo mecanismo, UriComponentsBuilder uriComponentsBuilder){

		if(mecanismo.getCodMecanismo().equals(null)||mecanismo.getCodMecanismo().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_mecanismoService.getMecanismoByName(mecanismo.getCodMecanismo()) != null) {

			return new ResponseEntity("The Mecanismo already exist", HttpStatus.CONFLICT);

		}

		_mecanismoService.createMecanismo(mecanismo);
		Mecanismo newMecanismo = _mecanismoService.getMecanismoByName(mecanismo.getCodMecanismo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Mecanismo/{id}")
				.buildAndExpand(newMecanismo.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Mecanismo/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Mecanismo> updateMecanismo(@PathVariable("id") Long idMecanismo, @RequestBody Mecanismo mecanismo){

		if(idMecanismo == null || idMecanismo <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Mecanismo newMecanismo = _mecanismoService.getMecanismoById(idMecanismo);
		if(newMecanismo == null) {

			return new ResponseEntity("There's no Mecanismo with the id", HttpStatus.CONFLICT);

		}

		newMecanismo.setUsuario(mecanismo.getUsuario());
		newMecanismo.setStatReg(mecanismo.getStatReg());

		_mecanismoService.updateMecanismo(newMecanismo);
		return new ResponseEntity<Mecanismo>(newMecanismo, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Mecanismo/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteMecanismoById(@PathVariable("id") Long idMecanismo){

		if(idMecanismo == null || idMecanismo <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Mecanismo mecanismo = _mecanismoService.getMecanismoById(idMecanismo);
		if(mecanismo == null) {

			return new ResponseEntity("Can't remove an inexistent Mecanismo", HttpStatus.CONFLICT);
		}

		_mecanismoService.removeMecanismo(idMecanismo);
		return new ResponseEntity(HttpStatus.OK);



	}

}
