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
import com.scm.gsoft.domain.inv.Consultas;
import com.scm.gsoft.service.inv.ConsultasService;

@Controller
@RequestMapping("/v1/inv")
public class ConsultasController {

	@Autowired
	private ConsultasService _consultasService;

	//GET
	@RequestMapping(value = "/Consultas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Consultas> getConsultasById(@PathVariable("id") Long idConsultas){

		if(idConsultas == null || idConsultas <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Consultas consultas = _consultasService.getConsultasById(idConsultas);
		if(consultas == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Consultas>(consultas, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Consultas", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Consultas>> getConsultasByName(@RequestParam(value = "name", required = false) String name){

		List<Consultas> consultasList = new ArrayList<>();

		if(name == null) {

			consultasList = _consultasService.getConsultasList();

			if(consultasList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Consultas>>(consultasList, HttpStatus.OK);

			}

		} else {

			Consultas consultas = _consultasService.getConsultasByName(name);

			if(consultas == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			consultasList.add(consultas);
			return new ResponseEntity<List<Consultas>>(consultasList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Consultas", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createConsultas(@RequestBody Consultas consultas, UriComponentsBuilder uriComponentsBuilder){

		if(consultas.getCodArt().equals(null)||consultas.getCodArt().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_consultasService.getConsultasByName(consultas.getCodArt()) != null) {

			return new ResponseEntity("The Consultas already exist", HttpStatus.CONFLICT);

		}

		_consultasService.createConsultas(consultas);
		Consultas newConsultas = _consultasService.getConsultasByName(consultas.getCodArt());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Consultas/{id}")
				.buildAndExpand(newConsultas.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Consultas/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Consultas> updateConsultas(@PathVariable("id") Long idConsultas, @RequestBody Consultas consultas){

		if(idConsultas == null || idConsultas <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Consultas newConsultas = _consultasService.getConsultasById(idConsultas);
		if(newConsultas == null) {

			return new ResponseEntity("There's no Consultas with the id", HttpStatus.CONFLICT);

		}
		
		newConsultas.setUsuario(consultas.getUsuario());		

		_consultasService.updateConsultas(newConsultas);
		return new ResponseEntity<Consultas>(newConsultas, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Consultas/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteConsultasById(@PathVariable("id") Long idConsultas){

		if(idConsultas == null || idConsultas <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Consultas consultas = _consultasService.getConsultasById(idConsultas);
		if(consultas == null) {

			return new ResponseEntity("Can't remove an inexistent Consultas", HttpStatus.CONFLICT);
		}

		_consultasService.removeConsultas(idConsultas);
		return new ResponseEntity(HttpStatus.OK);



	}

}
