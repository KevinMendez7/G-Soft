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
import com.scm.gsoft.domain.inv.MaebodDet;
import com.scm.gsoft.service.inv.MaebodDetService;

@Controller
@RequestMapping("/v1/inv")
public class MaebodDetController {

	@Autowired
	private MaebodDetService _maebodDetService;

	//GET
	@RequestMapping(value = "/MaebodDet/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<MaebodDet> getMaebodDetById(@PathVariable("id") Long idMaebodDet){

		if(idMaebodDet == null || idMaebodDet <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		MaebodDet maebodDet = _maebodDetService.getMaebodDetById(idMaebodDet);
		if(maebodDet == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<MaebodDet>(maebodDet, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/MaebodDet", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<MaebodDet>> getMaebodDetByName(@RequestParam(value = "name", required = false) String name){

		List<MaebodDet> maebodDetList = new ArrayList<>();

		if(name == null) {

			maebodDetList = _maebodDetService.getMaebodDetList();

			if(maebodDetList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<MaebodDet>>(maebodDetList, HttpStatus.OK);

			}

		} else {

			MaebodDet maebodDet = _maebodDetService.getMaebodDetByName(name);

			if(maebodDet == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			maebodDetList.add(maebodDet);
			return new ResponseEntity<List<MaebodDet>>(maebodDetList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/MaebodDet", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createMaebodDet(@RequestBody MaebodDet maebodDet, UriComponentsBuilder uriComponentsBuilder){

		if(maebodDet.getAnio().equals(null)||maebodDet.getAnio().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_maebodDetService.getMaebodDetByName(maebodDet.getAnio()) != null) {

			return new ResponseEntity("The MaebodDet already exist", HttpStatus.CONFLICT);

		}

		_maebodDetService.createMaebodDet(maebodDet);
		MaebodDet newMaebodDet = _maebodDetService.getMaebodDetByName(maebodDet.getAnio());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/MaebodDet/{id}")
				.buildAndExpand(newMaebodDet.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/MaebodDet/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<MaebodDet> updateMaebodDet(@PathVariable("id") Long idMaebodDet, @RequestBody MaebodDet maebodDet){

		if(idMaebodDet == null || idMaebodDet <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		MaebodDet newMaebodDet = _maebodDetService.getMaebodDetById(idMaebodDet);
		if(newMaebodDet == null) {

			return new ResponseEntity("There's no MaebodDet with the id", HttpStatus.CONFLICT);

		}

		newMaebodDet.setUsuario(maebodDet.getUsuario());
		newMaebodDet.setStatReg(maebodDet.getStatReg());

		_maebodDetService.updateMaebodDet(newMaebodDet);
		return new ResponseEntity<MaebodDet>(newMaebodDet, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/MaebodDet/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteMaebodDetById(@PathVariable("id") Long idMaebodDet){

		if(idMaebodDet == null || idMaebodDet <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		MaebodDet maebodDet = _maebodDetService.getMaebodDetById(idMaebodDet);
		if(maebodDet == null) {

			return new ResponseEntity("Can't remove an inexistent MaebodDet", HttpStatus.CONFLICT);
		}

		_maebodDetService.removeMaebodDet(idMaebodDet);
		return new ResponseEntity(HttpStatus.OK);



	}

}
