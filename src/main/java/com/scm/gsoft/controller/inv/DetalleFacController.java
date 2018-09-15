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
import com.scm.gsoft.domain.inv.DetalleFac;
import com.scm.gsoft.service.inv.DetalleFacService;

@Controller
@RequestMapping("/v1/inv")
public class DetalleFacController {

	@Autowired
	private DetalleFacService _detalleFacService;

	//GET
	@RequestMapping(value = "/DetalleFac/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<DetalleFac> getDetalleFacById(@PathVariable("id") Long idDetalleFac){

		if(idDetalleFac == null || idDetalleFac <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		DetalleFac detalleFac = _detalleFacService.getDetalleFacById(idDetalleFac);
		if(detalleFac == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<DetalleFac>(detalleFac, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/DetalleFac", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<DetalleFac>> getDetalleFacByName(@RequestParam(value = "name", required = false) String name){

		List<DetalleFac> detalleFacList = new ArrayList<>();

		if(name == null) {

			detalleFacList = _detalleFacService.getDetalleFacList();

			if(detalleFacList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<DetalleFac>>(detalleFacList, HttpStatus.OK);

			}

		} else {

			DetalleFac detalleFac = _detalleFacService.getDetalleFacByName(name);

			if(detalleFac == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			detalleFacList.add(detalleFac);
			return new ResponseEntity<List<DetalleFac>>(detalleFacList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/DetalleFac", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createDetalleFac(@RequestBody DetalleFac detalleFac, UriComponentsBuilder uriComponentsBuilder){

		if(detalleFac.getCodArt().equals(null)||detalleFac.getCodArt().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_detalleFacService.getDetalleFacByName(detalleFac.getCodArt()) != null) {

			return new ResponseEntity("The DetalleFac already exist", HttpStatus.CONFLICT);

		}

		_detalleFacService.createDetalleFac(detalleFac);
		DetalleFac newDetalleFac = _detalleFacService.getDetalleFacByName(detalleFac.getCodArt());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/DetalleFac/{id}")
				.buildAndExpand(newDetalleFac.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/DetalleFac/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<DetalleFac> updateDetalleFac(@PathVariable("id") Long idDetalleFac, @RequestBody DetalleFac detalleFac){

		if(idDetalleFac == null || idDetalleFac <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		DetalleFac newDetalleFac = _detalleFacService.getDetalleFacById(idDetalleFac);
		if(newDetalleFac == null) {

			return new ResponseEntity("There's no DetalleFac with the id", HttpStatus.CONFLICT);

		}

		newDetalleFac.setCodArt(detalleFac.getCodArt());		

		_detalleFacService.updateDetalleFac(newDetalleFac);
		return new ResponseEntity<DetalleFac>(newDetalleFac, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/DetalleFac/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteDetalleFacById(@PathVariable("id") Long idDetalleFac){

		if(idDetalleFac == null || idDetalleFac <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		DetalleFac detalleFac = _detalleFacService.getDetalleFacById(idDetalleFac);
		if(detalleFac == null) {

			return new ResponseEntity("Can't remove an inexistent DetalleFac", HttpStatus.CONFLICT);
		}

		_detalleFacService.removeDetalleFac(idDetalleFac);
		return new ResponseEntity(HttpStatus.OK);



	}

}
