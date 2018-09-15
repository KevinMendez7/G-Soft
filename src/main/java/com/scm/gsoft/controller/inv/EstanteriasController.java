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
import com.scm.gsoft.domain.inv.Estanterias;
import com.scm.gsoft.service.inv.EstanteriasService;

@Controller
@RequestMapping("/v1/inv")
public class EstanteriasController {

	@Autowired
	private EstanteriasService _estanteriasService;

	//GET
	@RequestMapping(value = "/Estanterias/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Estanterias> getEstanteriasById(@PathVariable("id") Long idEstanterias){

		if(idEstanterias == null || idEstanterias <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Estanterias estanterias = _estanteriasService.getEstanteriasById(idEstanterias);
		if(estanterias == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Estanterias>(estanterias, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Estanterias", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Estanterias>> getEstanteriasByName(@RequestParam(value = "name", required = false) String name){

		List<Estanterias> estanteriasList = new ArrayList<>();

		if(name == null) {

			estanteriasList = _estanteriasService.getEstanteriasList();

			if(estanteriasList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Estanterias>>(estanteriasList, HttpStatus.OK);

			}

		} else {

			Estanterias estanterias = _estanteriasService.getEstanteriasByName(name);

			if(estanterias == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			estanteriasList.add(estanterias);
			return new ResponseEntity<List<Estanterias>>(estanteriasList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Estanterias", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createEstanterias(@RequestBody Estanterias estanterias, UriComponentsBuilder uriComponentsBuilder){

		if(estanterias.getBodega().equals(null)||estanterias.getBodega().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_estanteriasService.getEstanteriasByName(estanterias.getBodega()) != null) {

			return new ResponseEntity("The Estanterias already exist", HttpStatus.CONFLICT);

		}

		_estanteriasService.createEstanterias(estanterias);
		Estanterias newEstanterias = _estanteriasService.getEstanteriasByName(estanterias.getBodega());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Estanterias/{id}")
				.buildAndExpand(newEstanterias.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Estanterias/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Estanterias> updateEstanterias(@PathVariable("id") Long idEstanterias, @RequestBody Estanterias estanterias){

		if(idEstanterias == null || idEstanterias <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Estanterias newEstanterias = _estanteriasService.getEstanteriasById(idEstanterias);
		if(newEstanterias == null) {

			return new ResponseEntity("There's no Estanterias with the id", HttpStatus.CONFLICT);

		}

		newEstanterias.setUsuario(estanterias.getUsuario());
		newEstanterias.setStatReg(estanterias.getStatReg());

		_estanteriasService.updateEstanterias(newEstanterias);
		return new ResponseEntity<Estanterias>(newEstanterias, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Estanterias/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteEstanteriasById(@PathVariable("id") Long idEstanterias){

		if(idEstanterias == null || idEstanterias <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Estanterias estanterias = _estanteriasService.getEstanteriasById(idEstanterias);
		if(estanterias == null) {

			return new ResponseEntity("Can't remove an inexistent Estanterias", HttpStatus.CONFLICT);
		}

		_estanteriasService.removeEstanterias(idEstanterias);
		return new ResponseEntity(HttpStatus.OK);



	}

}
