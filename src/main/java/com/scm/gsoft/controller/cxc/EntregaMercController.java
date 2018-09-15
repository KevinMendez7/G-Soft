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
import com.scm.gsoft.domain.cxc.EntregaMerc;
import com.scm.gsoft.service.cxc.EntregaMercService;

@Controller
@RequestMapping("/v1/cxc")
public class EntregaMercController {

	@Autowired
	private EntregaMercService _entregaMercService;

	//GET
	@RequestMapping(value = "/EntregaMerc/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<EntregaMerc> getEntregaMercById(@PathVariable("id") Long idEntregaMerc){

		if(idEntregaMerc == null || idEntregaMerc <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		EntregaMerc entregaMerc = _entregaMercService.getEntregaMercById(idEntregaMerc);
		if(entregaMerc == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<EntregaMerc>(entregaMerc, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/EntregaMerc", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<EntregaMerc>> getEntregaMercByName(@RequestParam(value = "name", required = false) String name){

		List<EntregaMerc> entregaMercList = new ArrayList<>();

		if(name == null) {

			entregaMercList = _entregaMercService.getEntregaMercList();

			if(entregaMercList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<EntregaMerc>>(entregaMercList, HttpStatus.OK);

			}

		} else {

			EntregaMerc entregaMerc = _entregaMercService.getEntregaMercByName(name);

			if(entregaMerc == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			entregaMercList.add(entregaMerc);
			return new ResponseEntity<List<EntregaMerc>>(entregaMercList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/EntregaMerc", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createEntregaMerc(@RequestBody EntregaMerc entregaMerc, UriComponentsBuilder uriComponentsBuilder){

		if(entregaMerc.getNumero().equals(null)||entregaMerc.getNumero().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_entregaMercService.getEntregaMercByName(entregaMerc.getNumero()) != null) {

			return new ResponseEntity("The EntregaMerc already exist", HttpStatus.CONFLICT);

		}

		_entregaMercService.createEntregaMerc(entregaMerc);
		EntregaMerc newEntregaMerc = _entregaMercService.getEntregaMercByName(entregaMerc.getNumero());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/EntregaMerc/{id}")
				.buildAndExpand(newEntregaMerc.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/EntregaMerc/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<EntregaMerc> updateEntregaMerc(@PathVariable("id") Long idEntregaMerc, @RequestBody EntregaMerc entregaMerc){

		if(idEntregaMerc == null || idEntregaMerc <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		EntregaMerc newEntregaMerc = _entregaMercService.getEntregaMercById(idEntregaMerc);
		if(newEntregaMerc == null) {

			return new ResponseEntity("There's no EntregaMerc with the id", HttpStatus.CONFLICT);

		}

		newEntregaMerc.setUsuario(entregaMerc.getUsuario());
		newEntregaMerc.setStatReg(entregaMerc.getStatReg());

		_entregaMercService.updateEntregaMerc(newEntregaMerc);
		return new ResponseEntity<EntregaMerc>(newEntregaMerc, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/EntregaMerc/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteEntregaMercById(@PathVariable("id") Long idEntregaMerc){

		if(idEntregaMerc == null || idEntregaMerc <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		EntregaMerc entregaMerc = _entregaMercService.getEntregaMercById(idEntregaMerc);
		if(entregaMerc == null) {

			return new ResponseEntity("Can't remove an inexistent EntregaMerc", HttpStatus.CONFLICT);
		}

		_entregaMercService.removeEntregaMerc(idEntregaMerc);
		return new ResponseEntity(HttpStatus.OK);



	}

}
