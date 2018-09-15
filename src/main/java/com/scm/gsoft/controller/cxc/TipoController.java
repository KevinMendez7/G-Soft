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
import com.scm.gsoft.domain.cxc.Tipo;
import com.scm.gsoft.service.cxc.TipoService;

@Controller("TipoControllerCxc")
@RequestMapping("/v1/cxc")
public class TipoController {

	@Autowired
	@Qualifier("TipoServiceCxc")
	private TipoService _tipoService;

	//GET
	@RequestMapping(value = "/Tipo/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Tipo> getTipoById(@PathVariable("id") Long idTipo){

		if(idTipo == null || idTipo <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Tipo tipo = _tipoService.getTipoById(idTipo);
		if(tipo == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Tipo>(tipo, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Tipo", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Tipo>> getTipoByName(@RequestParam(value = "name", required = false) String name){

		List<Tipo> tipoList = new ArrayList<>();

		if(name == null) {

			tipoList = _tipoService.getTipoList();

			if(tipoList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Tipo>>(tipoList, HttpStatus.OK);

			}

		} else {

			Tipo tipo = _tipoService.getTipoByName(name);

			if(tipo == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			tipoList.add(tipo);
			return new ResponseEntity<List<Tipo>>(tipoList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Tipo", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createTipo(@RequestBody Tipo tipo, UriComponentsBuilder uriComponentsBuilder){

		if(tipo.getCorrelativo().equals(null)||tipo.getCorrelativo().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_tipoService.getTipoByName(tipo.getCorrelativo()) != null) {

			return new ResponseEntity("The Tipo already exist", HttpStatus.CONFLICT);

		}

		_tipoService.createTipo(tipo);
		Tipo newTipo = _tipoService.getTipoByName(tipo.getCorrelativo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Tipo/{id}")
				.buildAndExpand(newTipo.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Tipo/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Tipo> updateTipo(@PathVariable("id") Long idTipo, @RequestBody Tipo tipo){

		if(idTipo == null || idTipo <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Tipo newTipo = _tipoService.getTipoById(idTipo);
		if(newTipo == null) {

			return new ResponseEntity("There's no Tipo with the id", HttpStatus.CONFLICT);

		}

		newTipo.setCodigo(tipo.getCodigo());		

		_tipoService.updateTipo(newTipo);
		return new ResponseEntity<Tipo>(newTipo, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Tipo/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteTipoById(@PathVariable("id") Long idTipo){

		if(idTipo == null || idTipo <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Tipo tipo = _tipoService.getTipoById(idTipo);
		if(tipo == null) {

			return new ResponseEntity("Can't remove an inexistent Tipo", HttpStatus.CONFLICT);
		}

		_tipoService.removeTipo(idTipo);
		return new ResponseEntity(HttpStatus.OK);



	}

}
