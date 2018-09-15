package com.scm.gsoft.controller.cxc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.scm.gsoft.domain.cxc.Depto;
import com.scm.gsoft.service.cxc.DeptoService;

@Controller("DeptoControllerCxc")
@RequestMapping("/v1/cxc")
public class DeptoController {

	@Autowired
	@Qualifier("DeptoServiceCxc")
	private DeptoService _deptoService;

	//GET
	@RequestMapping(value = "/Depto/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Depto> getDeptoById(@PathVariable("id") Long idDepto){

		if(idDepto == null || idDepto <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Depto depto = _deptoService.getDeptoById(idDepto);
		if(depto == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Depto>(depto, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Depto", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Depto>> getDeptoByName(@RequestParam(value = "name", required = false) String name){

		List<Depto> deptoList = new ArrayList<>();

		if(name == null) {

			deptoList = _deptoService.getDeptoList();

			if(deptoList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Depto>>(deptoList, HttpStatus.OK);

			}

		} else {

			Depto depto = _deptoService.getDeptoByName(name);

			if(depto == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			deptoList.add(depto);
			return new ResponseEntity<List<Depto>>(deptoList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Depto", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createDepto(@RequestBody Depto depto, UriComponentsBuilder uriComponentsBuilder){

		if(depto.getCodigo().equals(null)||depto.getCodigo().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_deptoService.getDeptoByName(depto.getCodigo()) != null) {

			return new ResponseEntity("The Depto already exist", HttpStatus.CONFLICT);

		}

		_deptoService.createDepto(depto);
		Depto newDepto = _deptoService.getDeptoByName(depto.getCodigo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Depto/{id}")
				.buildAndExpand(newDepto.getIdDepto())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Depto/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Depto> updateDepto(@PathVariable("id") Long idDepto, @RequestBody Depto depto){

		if(idDepto == null || idDepto <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Depto newDepto = _deptoService.getDeptoById(idDepto);
		if(newDepto == null) {

			return new ResponseEntity("There's no Depto with the id", HttpStatus.CONFLICT);

		}

		newDepto.setCodigo(depto.getCodigo());		

		_deptoService.updateDepto(newDepto);
		return new ResponseEntity<Depto>(newDepto, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Depto/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteDeptoById(@PathVariable("id") Long idDepto){

		if(idDepto == null || idDepto <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Depto depto = _deptoService.getDeptoById(idDepto);
		if(depto == null) {

			return new ResponseEntity("Can't remove an inexistent Depto", HttpStatus.CONFLICT);
		}

		_deptoService.removeDepto(idDepto);
		return new ResponseEntity(HttpStatus.OK);



	}

}
