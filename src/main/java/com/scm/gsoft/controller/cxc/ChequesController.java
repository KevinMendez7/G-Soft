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
import com.scm.gsoft.domain.cxc.Cheques;
import com.scm.gsoft.service.cxc.ChequesService;

@Controller
@RequestMapping("/v1/cxc")
public class ChequesController {

	@Autowired
	private ChequesService _chequesService;

	//GET
	@RequestMapping(value = "/Cheques/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Cheques> getChequesById(@PathVariable("id") Long idCheques){

		if(idCheques == null || idCheques <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Cheques cheques = _chequesService.getChequesById(idCheques);
		if(cheques == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Cheques>(cheques, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Cheques", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Cheques>> getChequesByName(@RequestParam(value = "name", required = false) String name){

		List<Cheques> chequesList = new ArrayList<>();

		if(name == null) {

			chequesList = _chequesService.getChequesList();

			if(chequesList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Cheques>>(chequesList, HttpStatus.OK);

			}

		} else {

			Cheques cheques = _chequesService.getChequesByName(name);

			if(cheques == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			chequesList.add(cheques);
			return new ResponseEntity<List<Cheques>>(chequesList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Cheques", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCheques(@RequestBody Cheques cheques, UriComponentsBuilder uriComponentsBuilder){

		if(cheques.getNumeroCh().equals(null)||cheques.getNumeroCh().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_chequesService.getChequesByName(cheques.getNumeroCh()) != null) {

			return new ResponseEntity("The Cheques already exist", HttpStatus.CONFLICT);

		}

		_chequesService.createCheques(cheques);
		Cheques newCheques = _chequesService.getChequesByName(cheques.getNumeroCh());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Cheques/{id}")
				.buildAndExpand(newCheques.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Cheques/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Cheques> updateCheques(@PathVariable("id") Long idCheques, @RequestBody Cheques cheques){

		if(idCheques == null || idCheques <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Cheques newCheques = _chequesService.getChequesById(idCheques);
		if(newCheques == null) {

			return new ResponseEntity("There's no Cheques with the id", HttpStatus.CONFLICT);

		}

		newCheques.setUsuario(cheques.getUsuario());
		newCheques.setStatReg(cheques.getStatReg());

		_chequesService.updateCheques(newCheques);
		return new ResponseEntity<Cheques>(newCheques, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Cheques/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteChequesById(@PathVariable("id") Long idCheques){

		if(idCheques == null || idCheques <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Cheques cheques = _chequesService.getChequesById(idCheques);
		if(cheques == null) {

			return new ResponseEntity("Can't remove an inexistent Cheques", HttpStatus.CONFLICT);
		}

		_chequesService.removeCheques(idCheques);
		return new ResponseEntity(HttpStatus.OK);



	}

}
