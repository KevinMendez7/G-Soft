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
import com.scm.gsoft.domain.cxc.DetallePl;
import com.scm.gsoft.service.cxc.DetallePlService;

@Controller
@RequestMapping("/v1/cxc")
public class DetallePlController {

	@Autowired
	private DetallePlService _detallePlService;

	//GET
	@RequestMapping(value = "/DetallePl/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<DetallePl> getDetallePlById(@PathVariable("id") Long idDetallePl){

		if(idDetallePl == null || idDetallePl <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		DetallePl detallePl = _detallePlService.getDetallePlById(idDetallePl);
		if(detallePl == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<DetallePl>(detallePl, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/DetallePl", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<DetallePl>> getDetallePlByName(@RequestParam(value = "name", required = false) String name){

		List<DetallePl> detallePlList = new ArrayList<>();

		if(name == null) {

			detallePlList = _detallePlService.getDetallePlList();

			if(detallePlList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<DetallePl>>(detallePlList, HttpStatus.OK);

			}

		} else {

			DetallePl detallePl = _detallePlService.getDetallePlByName(name);

			if(detallePl == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			detallePlList.add(detallePl);
			return new ResponseEntity<List<DetallePl>>(detallePlList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/DetallePl", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createDetallePl(@RequestBody DetallePl detallePl, UriComponentsBuilder uriComponentsBuilder){

		if(detallePl.getRegistro().equals(null)||detallePl.getRegistro().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_detallePlService.getDetallePlByName(detallePl.getRegistro()) != null) {

			return new ResponseEntity("The DetallePl already exist", HttpStatus.CONFLICT);

		}

		_detallePlService.createDetallePl(detallePl);
		DetallePl newDetallePl = _detallePlService.getDetallePlByName(detallePl.getRegistro());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/DetallePl/{id}")
				.buildAndExpand(newDetallePl.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/DetallePl/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<DetallePl> updateDetallePl(@PathVariable("id") Long idDetallePl, @RequestBody DetallePl detallePl){

		if(idDetallePl == null || idDetallePl <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		DetallePl newDetallePl = _detallePlService.getDetallePlById(idDetallePl);
		if(newDetallePl == null) {

			return new ResponseEntity("There's no DetallePl with the id", HttpStatus.CONFLICT);

		}

		
		newDetallePl.setRegistro(detallePl.getRegistro());
		newDetallePl.setUsuario(detallePl.getUsuario());
		newDetallePl.setStatReg(detallePl.getStatReg());

		_detallePlService.updateDetallePl(newDetallePl);
		return new ResponseEntity<DetallePl>(newDetallePl, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/DetallePl/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteDetallePlById(@PathVariable("id") Long idDetallePl){

		if(idDetallePl == null || idDetallePl <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		DetallePl detallePl = _detallePlService.getDetallePlById(idDetallePl);
		if(detallePl == null) {

			return new ResponseEntity("Can't remove an inexistent DetallePl", HttpStatus.CONFLICT);
		}

		_detallePlService.removeDetallePl(idDetallePl);
		return new ResponseEntity(HttpStatus.OK);



	}

}
