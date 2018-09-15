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
import com.scm.gsoft.domain.inv.Provee;
import com.scm.gsoft.service.inv.ProveeService;

@Controller
@RequestMapping("/v1/inv")
public class ProveeController {

	@Autowired
	private ProveeService _proveeService;

	//GET
	@RequestMapping(value = "/Provee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Provee> getProveeById(@PathVariable("id") Long idProvee){

		if(idProvee == null || idProvee <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Provee provee = _proveeService.getProveeById(idProvee);
		if(provee == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Provee>(provee, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Provee", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Provee>> getProveeByName(@RequestParam(value = "name", required = false) String name){

		List<Provee> proveeList = new ArrayList<>();

		if(name == null) {

			proveeList = _proveeService.getProveeList();

			if(proveeList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Provee>>(proveeList, HttpStatus.OK);

			}

		} else {

			Provee provee = _proveeService.getProveeByName(name);

			if(provee == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			proveeList.add(provee);
			return new ResponseEntity<List<Provee>>(proveeList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Provee", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createProvee(@RequestBody Provee provee, UriComponentsBuilder uriComponentsBuilder){

		if(provee.getNombre().equals(null)||provee.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_proveeService.getProveeByName(provee.getNombre()) != null) {

			return new ResponseEntity("The Provee already exist", HttpStatus.CONFLICT);

		}

		_proveeService.createProvee(provee);
		Provee newProvee = _proveeService.getProveeByName(provee.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Provee/{id}")
				.buildAndExpand(newProvee.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Provee/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Provee> updateProvee(@PathVariable("id") Long idProvee, @RequestBody Provee provee){

		if(idProvee == null || idProvee <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Provee newProvee = _proveeService.getProveeById(idProvee);
		if(newProvee == null) {

			return new ResponseEntity("There's no Provee with the id", HttpStatus.CONFLICT);

		}

		newProvee.setCodigo(provee.getCodigo());
		newProvee.setNombre(provee.getNombre());
		newProvee.setUsuario(provee.getUsuario());
		newProvee.setStatReg(provee.getStatReg());

		_proveeService.updateProvee(newProvee);
		return new ResponseEntity<Provee>(newProvee, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Provee/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteProveeById(@PathVariable("id") Long idProvee){

		if(idProvee == null || idProvee <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Provee provee = _proveeService.getProveeById(idProvee);
		if(provee == null) {

			return new ResponseEntity("Can't remove an inexistent Provee", HttpStatus.CONFLICT);
		}

		_proveeService.removeProvee(idProvee);
		return new ResponseEntity(HttpStatus.OK);



	}

}
