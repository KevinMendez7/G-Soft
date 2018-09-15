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
import com.scm.gsoft.domain.cxc.Estado;
import com.scm.gsoft.service.cxc.EstadoService;

@Controller
@RequestMapping("/v1/cxc")
public class EstadoController {

	@Autowired
	private EstadoService _estadoService;

	//GET
	@RequestMapping(value = "/Estado/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Estado> getEstadoById(@PathVariable("id") Long idEstado){

		if(idEstado == null || idEstado <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Estado estado = _estadoService.getEstadoById(idEstado);
		if(estado == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Estado>(estado, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Estado", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Estado>> getEstadoByName(@RequestParam(value = "name", required = false) String name){

		List<Estado> estadoList = new ArrayList<>();

		if(name == null) {

			estadoList = _estadoService.getEstadoList();

			if(estadoList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Estado>>(estadoList, HttpStatus.OK);

			}

		} else {

			Estado estado = _estadoService.getEstadoByName(name);

			if(estado == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			estadoList.add(estado);
			return new ResponseEntity<List<Estado>>(estadoList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Estado", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createEstado(@RequestBody Estado estado, UriComponentsBuilder uriComponentsBuilder){

		if(estado.getRecibo().equals(null)||estado.getRecibo().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_estadoService.getEstadoByName(estado.getRecibo()) != null) {

			return new ResponseEntity("The Estado already exist", HttpStatus.CONFLICT);

		}

		_estadoService.createEstado(estado);
		Estado newEstado = _estadoService.getEstadoByName(estado.getRecibo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Estado/{id}")
				.buildAndExpand(newEstado.getIdEstado())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Estado/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Estado> updateEstado(@PathVariable("id") Long idEstado, @RequestBody Estado estado){

		if(idEstado == null || idEstado <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Estado newEstado = _estadoService.getEstadoById(idEstado);
		if(newEstado == null) {

			return new ResponseEntity("There's no Estado with the id", HttpStatus.CONFLICT);

		}

		newEstado.setNombre1(estado.getNombre1());

		_estadoService.updateEstado(newEstado);
		return new ResponseEntity<Estado>(newEstado, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Estado/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteEstadoById(@PathVariable("id") Long idEstado){

		if(idEstado == null || idEstado <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Estado estado = _estadoService.getEstadoById(idEstado);
		if(estado == null) {

			return new ResponseEntity("Can't remove an inexistent Estado", HttpStatus.CONFLICT);
		}

		_estadoService.removeEstado(idEstado);
		return new ResponseEntity(HttpStatus.OK);



	}

}
