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
import com.scm.gsoft.domain.inv.Clasi;
import com.scm.gsoft.service.inv.ClasiService;

@Controller
@RequestMapping("/v1/inv")
public class ClasiController {

	@Autowired
	private ClasiService _clasiService;

	//GET
	@RequestMapping(value = "/Clasi/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Clasi> getClasiById(@PathVariable("id") Long idClasi){

		if(idClasi == null || idClasi <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Clasi clasi = _clasiService.getClasiById(idClasi);
		if(clasi == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Clasi>(clasi, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Clasi", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Clasi>> getClasiByName(@RequestParam(value = "name", required = false) String name){

		List<Clasi> clasiList = new ArrayList<>();

		if(name == null) {

			clasiList = _clasiService.getClasiList();

			if(clasiList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Clasi>>(clasiList, HttpStatus.OK);

			}

		} else {

			Clasi clasi = _clasiService.getClasiByName(name);

			if(clasi == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			clasiList.add(clasi);
			return new ResponseEntity<List<Clasi>>(clasiList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Clasi", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createClasi(@RequestBody Clasi clasi, UriComponentsBuilder uriComponentsBuilder){

		if(clasi.getNombre().equals(null)||clasi.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_clasiService.getClasiByName(clasi.getNombre()) != null) {

			return new ResponseEntity("The Clasi already exist", HttpStatus.CONFLICT);

		}

		_clasiService.createClasi(clasi);
		Clasi newClasi = _clasiService.getClasiByName(clasi.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Clasi/{id}")
				.buildAndExpand(newClasi.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Clasi/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Clasi> updateClasi(@PathVariable("id") Long idClasi, @RequestBody Clasi clasi){

		if(idClasi == null || idClasi <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Clasi newClasi = _clasiService.getClasiById(idClasi);
		if(newClasi == null) {

			return new ResponseEntity("There's no Clasi with the id", HttpStatus.CONFLICT);

		}

		newClasi.setCodigo(clasi.getCodigo());
		newClasi.setNombre(clasi.getNombre());

		_clasiService.updateClasi(newClasi);
		return new ResponseEntity<Clasi>(newClasi, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Clasi/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteClasiById(@PathVariable("id") Long idClasi){

		if(idClasi == null || idClasi <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Clasi clasi = _clasiService.getClasiById(idClasi);
		if(clasi == null) {

			return new ResponseEntity("Can't remove an inexistent Clasi", HttpStatus.CONFLICT);
		}

		_clasiService.removeClasi(idClasi);
		return new ResponseEntity(HttpStatus.OK);



	}

}
