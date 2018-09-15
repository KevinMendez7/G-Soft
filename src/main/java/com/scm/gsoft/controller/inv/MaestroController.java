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
import com.scm.gsoft.domain.inv.Maestro;
import com.scm.gsoft.service.inv.MaestroService;

@Controller
@RequestMapping("/v1/inv")
public class MaestroController {

	@Autowired
	private MaestroService _maestroService;

	//GET
	@RequestMapping(value = "/Maestro/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Maestro> getMaestroById(@PathVariable("id") Long idMaestro){

		if(idMaestro == null || idMaestro <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Maestro maestro = _maestroService.getMaestroById(idMaestro);
		if(maestro == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Maestro>(maestro, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Maestro", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Maestro>> getMaestroByName(@RequestParam(value = "name", required = false) String name){

		List<Maestro> maestroList = new ArrayList<>();

		if(name == null) {

			maestroList = _maestroService.getMaestroList();

			if(maestroList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Maestro>>(maestroList, HttpStatus.OK);

			}

		} else {

			Maestro maestro = _maestroService.getMaestroByName(name);

			if(maestro == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			maestroList.add(maestro);
			return new ResponseEntity<List<Maestro>>(maestroList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Maestro", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createMaestro(@RequestBody Maestro maestro, UriComponentsBuilder uriComponentsBuilder){

		if(maestro.getNombre().equals(null)||maestro.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_maestroService.getMaestroByName(maestro.getNombre()) != null) {

			return new ResponseEntity("The Maestro already exist", HttpStatus.CONFLICT);

		}

		_maestroService.createMaestro(maestro);
		Maestro newMaestro = _maestroService.getMaestroByName(maestro.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Maestro/{id}")
				.buildAndExpand(newMaestro.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Maestro/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Maestro> updateMaestro(@PathVariable("id") Long idMaestro, @RequestBody Maestro maestro){

		if(idMaestro == null || idMaestro <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Maestro newMaestro = _maestroService.getMaestroById(idMaestro);
		if(newMaestro == null) {

			return new ResponseEntity("There's no Maestro with the id", HttpStatus.CONFLICT);

		}

		newMaestro.setNombre(maestro.getNombre());
		newMaestro.setUsuario(maestro.getUsuario());
		newMaestro.setStatReg(maestro.getStatReg());

		_maestroService.updateMaestro(newMaestro);
		return new ResponseEntity<Maestro>(newMaestro, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Maestro/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteMaestroById(@PathVariable("id") Long idMaestro){

		if(idMaestro == null || idMaestro <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Maestro maestro = _maestroService.getMaestroById(idMaestro);
		if(maestro == null) {

			return new ResponseEntity("Can't remove an inexistent Maestro", HttpStatus.CONFLICT);
		}

		_maestroService.removeMaestro(idMaestro);
		return new ResponseEntity(HttpStatus.OK);



	}

}
