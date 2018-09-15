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
import com.scm.gsoft.domain.cxc.DetalleRec;
import com.scm.gsoft.service.cxc.DetalleRecService;

@Controller
@RequestMapping("/v1/cxc")
public class DetalleRecController {

	@Autowired
	private DetalleRecService _detalleRecService;

	//GET
	@RequestMapping(value = "/DetalleRec/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<DetalleRec> getDetalleRecById(@PathVariable("id") Long idDetalleRec){

		if(idDetalleRec == null || idDetalleRec <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		DetalleRec detalleRec = _detalleRecService.getDetalleRecById(idDetalleRec);
		if(detalleRec == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<DetalleRec>(detalleRec, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/DetalleRec", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<DetalleRec>> getDetalleRecByName(@RequestParam(value = "name", required = false) String name){

		List<DetalleRec> detalleRecList = new ArrayList<>();

		if(name == null) {

			detalleRecList = _detalleRecService.getDetalleRecList();

			if(detalleRecList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<DetalleRec>>(detalleRecList, HttpStatus.OK);

			}

		} else {

			DetalleRec detalleRec = _detalleRecService.getDetalleRecByName(name);

			if(detalleRec == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			detalleRecList.add(detalleRec);
			return new ResponseEntity<List<DetalleRec>>(detalleRecList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/DetalleRec", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createDetalleRec(@RequestBody DetalleRec detalleRec, UriComponentsBuilder uriComponentsBuilder){

		if(detalleRec.getNumFac().equals(null)||detalleRec.getNumFac().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_detalleRecService.getDetalleRecByName(detalleRec.getNumFac()) != null) {

			return new ResponseEntity("The DetalleRec already exist", HttpStatus.CONFLICT);

		}

		_detalleRecService.createDetalleRec(detalleRec);
		DetalleRec newDetalleRec = _detalleRecService.getDetalleRecByName(detalleRec.getNumFac());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/DetalleRec/{id}")
				.buildAndExpand(newDetalleRec.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/DetalleRec/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<DetalleRec> updateDetalleRec(@PathVariable("id") Long idDetalleRec, @RequestBody DetalleRec detalleRec){

		if(idDetalleRec == null || idDetalleRec <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		DetalleRec newDetalleRec = _detalleRecService.getDetalleRecById(idDetalleRec);
		if(newDetalleRec == null) {

			return new ResponseEntity("There's no DetalleRec with the id", HttpStatus.CONFLICT);

		}

		newDetalleRec.setDctofac(detalleRec.getDctofac());

		_detalleRecService.updateDetalleRec(newDetalleRec);
		return new ResponseEntity<DetalleRec>(newDetalleRec, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/DetalleRec/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteDetalleRecById(@PathVariable("id") Long idDetalleRec){

		if(idDetalleRec == null || idDetalleRec <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		DetalleRec detalleRec = _detalleRecService.getDetalleRecById(idDetalleRec);
		if(detalleRec == null) {

			return new ResponseEntity("Can't remove an inexistent DetalleRec", HttpStatus.CONFLICT);
		}

		_detalleRecService.removeDetalleRec(idDetalleRec);
		return new ResponseEntity(HttpStatus.OK);



	}

}
