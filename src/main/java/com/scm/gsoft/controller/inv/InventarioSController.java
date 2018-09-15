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
import com.scm.gsoft.domain.inv.InventarioS;
import com.scm.gsoft.service.inv.InventarioSService;

@Controller
@RequestMapping("/v1/inv")
public class InventarioSController {

	@Autowired
	private InventarioSService _inventarioSService;

	//GET
	@RequestMapping(value = "/InventarioS/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<InventarioS> getInventarioSById(@PathVariable("id") Long idInventarioS){

		if(idInventarioS == null || idInventarioS <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		InventarioS inventarioS = _inventarioSService.getInventarioSById(idInventarioS);
		if(inventarioS == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<InventarioS>(inventarioS, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/InventarioS", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<InventarioS>> getInventarioSByName(@RequestParam(value = "name", required = false) String name){

		List<InventarioS> inventarioSList = new ArrayList<>();

		if(name == null) {

			inventarioSList = _inventarioSService.getInventarioSList();

			if(inventarioSList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<InventarioS>>(inventarioSList, HttpStatus.OK);

			}

		} else {

			InventarioS inventarioS = _inventarioSService.getInventarioSByName(name);

			if(inventarioS == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			inventarioSList.add(inventarioS);
			return new ResponseEntity<List<InventarioS>>(inventarioSList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/InventarioS", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createInventarioS(@RequestBody InventarioS inventarioS, UriComponentsBuilder uriComponentsBuilder){

		if(inventarioS.getAnio().equals(null)||inventarioS.getAnio().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_inventarioSService.getInventarioSByName(inventarioS.getAnio()) != null) {

			return new ResponseEntity("The InventarioS already exist", HttpStatus.CONFLICT);

		}

		_inventarioSService.createInventarioS(inventarioS);
		InventarioS newInventarioS = _inventarioSService.getInventarioSByName(inventarioS.getAnio());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/InventarioS/{id}")
				.buildAndExpand(newInventarioS.getIdInventarioS())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/InventarioS/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<InventarioS> updateInventarioS(@PathVariable("id") Long idInventarioS, @RequestBody InventarioS inventarioS){

		if(idInventarioS == null || idInventarioS <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		InventarioS newInventarioS = _inventarioSService.getInventarioSById(idInventarioS);
		if(newInventarioS == null) {

			return new ResponseEntity("There's no InventarioS with the id", HttpStatus.CONFLICT);

		}

		newInventarioS.setAnio(inventarioS.getAnio());	

		_inventarioSService.updateInventarioS(newInventarioS);
		return new ResponseEntity<InventarioS>(newInventarioS, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/InventarioS/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteInventarioSById(@PathVariable("id") Long idInventarioS){

		if(idInventarioS == null || idInventarioS <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		InventarioS inventarioS = _inventarioSService.getInventarioSById(idInventarioS);
		if(inventarioS == null) {

			return new ResponseEntity("Can't remove an inexistent InventarioS", HttpStatus.CONFLICT);
		}

		_inventarioSService.removeInventarioS(idInventarioS);
		return new ResponseEntity(HttpStatus.OK);



	}

}
