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
import com.scm.gsoft.domain.inv.Maebod;
import com.scm.gsoft.service.inv.MaebodService;

@Controller
@RequestMapping("/v1/inv")
public class MaebodController {

	@Autowired
	private MaebodService _maebodService;

	//GET
	@RequestMapping(value = "/Maebod/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Maebod> getMaebodById(@PathVariable("id") Long idMaebod){

		if(idMaebod == null || idMaebod <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Maebod maebod = _maebodService.getMaebodById(idMaebod);
		if(maebod == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Maebod>(maebod, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Maebod", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Maebod>> getMaebodByName(@RequestParam(value = "name", required = false) String name){

		List<Maebod> maebodList = new ArrayList<>();

		if(name == null) {

			maebodList = _maebodService.getMaebodList();

			if(maebodList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Maebod>>(maebodList, HttpStatus.OK);

			}

		} else {

			Maebod maebod = _maebodService.getMaebodByName(name);

			if(maebod == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			maebodList.add(maebod);
			return new ResponseEntity<List<Maebod>>(maebodList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Maebod", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createMaebod(@RequestBody Maebod maebod, UriComponentsBuilder uriComponentsBuilder){

		if(maebod.getBodega().equals(null)||maebod.getBodega().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_maebodService.getMaebodByName(maebod.getBodega()) != null) {

			return new ResponseEntity("The Maebod already exist", HttpStatus.CONFLICT);

		}

		_maebodService.createMaebod(maebod);
		Maebod newMaebod = _maebodService.getMaebodByName(maebod.getBodega());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Maebod/{id}")
				.buildAndExpand(newMaebod.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Maebod/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Maebod> updateMaebod(@PathVariable("id") Long idMaebod, @RequestBody Maebod maebod){

		if(idMaebod == null || idMaebod <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Maebod newMaebod = _maebodService.getMaebodById(idMaebod);
		if(newMaebod == null) {

			return new ResponseEntity("There's no Maebod with the id", HttpStatus.CONFLICT);

		}

		newMaebod.setUsuario(maebod.getUsuario());
		newMaebod.setStatReg(maebod.getStatReg());

		_maebodService.updateMaebod(newMaebod);
		return new ResponseEntity<Maebod>(newMaebod, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Maebod/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteMaebodById(@PathVariable("id") Long idMaebod){

		if(idMaebod == null || idMaebod <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Maebod maebod = _maebodService.getMaebodById(idMaebod);
		if(maebod == null) {

			return new ResponseEntity("Can't remove an inexistent Maebod", HttpStatus.CONFLICT);
		}

		_maebodService.removeMaebod(idMaebod);
		return new ResponseEntity(HttpStatus.OK);



	}

}
