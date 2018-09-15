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
import com.scm.gsoft.domain.inv.MaebodPreciosHist;
import com.scm.gsoft.service.inv.MaebodPreciosHistService;

@Controller
@RequestMapping("/v1/inv")
public class MaebodPreciosHistController {

	@Autowired
	private MaebodPreciosHistService _maebodPreciosHistService;

	//GET
	@RequestMapping(value = "/MaebodPreciosHist/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<MaebodPreciosHist> getMaebodPreciosHistById(@PathVariable("id") Long idMaebodPreciosHist){

		if(idMaebodPreciosHist == null || idMaebodPreciosHist <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		MaebodPreciosHist maebodPreciosHist = _maebodPreciosHistService.getMaebodPreciosHistById(idMaebodPreciosHist);
		if(maebodPreciosHist == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<MaebodPreciosHist>(maebodPreciosHist, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/MaebodPreciosHist", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<MaebodPreciosHist>> getMaebodPreciosHistByName(@RequestParam(value = "name", required = false) String name){

		List<MaebodPreciosHist> maebodPreciosHistList = new ArrayList<>();

		if(name == null) {

			maebodPreciosHistList = _maebodPreciosHistService.getMaebodPreciosHistList();

			if(maebodPreciosHistList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<MaebodPreciosHist>>(maebodPreciosHistList, HttpStatus.OK);

			}

		} else {

			MaebodPreciosHist maebodPreciosHist = _maebodPreciosHistService.getMaebodPreciosHistByName(name);

			if(maebodPreciosHist == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			maebodPreciosHistList.add(maebodPreciosHist);
			return new ResponseEntity<List<MaebodPreciosHist>>(maebodPreciosHistList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/MaebodPreciosHist", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createMaebodPreciosHist(@RequestBody MaebodPreciosHist maebodPreciosHist, UriComponentsBuilder uriComponentsBuilder){

		if(maebodPreciosHist.getBodega().equals(null)||maebodPreciosHist.getBodega().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_maebodPreciosHistService.getMaebodPreciosHistByName(maebodPreciosHist.getBodega()) != null) {

			return new ResponseEntity("The MaebodPreciosHist already exist", HttpStatus.CONFLICT);

		}

		_maebodPreciosHistService.createMaebodPreciosHist(maebodPreciosHist);
		MaebodPreciosHist newMaebodPreciosHist = _maebodPreciosHistService.getMaebodPreciosHistByName(maebodPreciosHist.getBodega());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/MaebodPreciosHist/{id}")
				.buildAndExpand(newMaebodPreciosHist.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/MaebodPreciosHist/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<MaebodPreciosHist> updateMaebodPreciosHist(@PathVariable("id") Long idMaebodPreciosHist, @RequestBody MaebodPreciosHist maebodPreciosHist){

		if(idMaebodPreciosHist == null || idMaebodPreciosHist <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		MaebodPreciosHist newMaebodPreciosHist = _maebodPreciosHistService.getMaebodPreciosHistById(idMaebodPreciosHist);
		if(newMaebodPreciosHist == null) {

			return new ResponseEntity("There's no MaebodPreciosHist with the id", HttpStatus.CONFLICT);

		}

		newMaebodPreciosHist.setUsuario(maebodPreciosHist.getUsuario());
		newMaebodPreciosHist.setStatReg(maebodPreciosHist.getStatReg());

		_maebodPreciosHistService.updateMaebodPreciosHist(newMaebodPreciosHist);
		return new ResponseEntity<MaebodPreciosHist>(newMaebodPreciosHist, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/MaebodPreciosHist/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteMaebodPreciosHistById(@PathVariable("id") Long idMaebodPreciosHist){

		if(idMaebodPreciosHist == null || idMaebodPreciosHist <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		MaebodPreciosHist maebodPreciosHist = _maebodPreciosHistService.getMaebodPreciosHistById(idMaebodPreciosHist);
		if(maebodPreciosHist == null) {

			return new ResponseEntity("Can't remove an inexistent MaebodPreciosHist", HttpStatus.CONFLICT);
		}

		_maebodPreciosHistService.removeMaebodPreciosHist(idMaebodPreciosHist);
		return new ResponseEntity(HttpStatus.OK);



	}

}
