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
import com.scm.gsoft.domain.inv.Lado;
import com.scm.gsoft.service.inv.LadoService;

@Controller
@RequestMapping("/v1/inv")
public class LadoController {

	@Autowired
	private LadoService _ladoService;

	//GET
	@RequestMapping(value = "/Lado/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Lado> getLadoById(@PathVariable("id") Long idLado){

		if(idLado == null || idLado <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Lado lado = _ladoService.getLadoById(idLado);
		if(lado == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Lado>(lado, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Lado", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Lado>> getLadoByName(@RequestParam(value = "name", required = false) String name){

		List<Lado> ladoList = new ArrayList<>();

		if(name == null) {

			ladoList = _ladoService.getLadoList();

			if(ladoList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Lado>>(ladoList, HttpStatus.OK);

			}

		} else {

			Lado lado = _ladoService.getLadoByName(name);

			if(lado == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			ladoList.add(lado);
			return new ResponseEntity<List<Lado>>(ladoList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Lado", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createLado(@RequestBody Lado lado, UriComponentsBuilder uriComponentsBuilder){

		if(lado.getCodLado().equals(null)||lado.getCodLado().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_ladoService.getLadoByName(lado.getCodLado()) != null) {

			return new ResponseEntity("The Lado already exist", HttpStatus.CONFLICT);

		}

		_ladoService.createLado(lado);
		Lado newLado = _ladoService.getLadoByName(lado.getCodLado());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Lado/{id}")
				.buildAndExpand(newLado.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Lado/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Lado> updateLado(@PathVariable("id") Long idLado, @RequestBody Lado lado){

		if(idLado == null || idLado <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Lado newLado = _ladoService.getLadoById(idLado);
		if(newLado == null) {

			return new ResponseEntity("There's no Lado with the id", HttpStatus.CONFLICT);

		}

		newLado.setUsuario(lado.getUsuario());
		newLado.setStatReg(lado.getStatReg());

		_ladoService.updateLado(newLado);
		return new ResponseEntity<Lado>(newLado, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Lado/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteLadoById(@PathVariable("id") Long idLado){

		if(idLado == null || idLado <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Lado lado = _ladoService.getLadoById(idLado);
		if(lado == null) {

			return new ResponseEntity("Can't remove an inexistent Lado", HttpStatus.CONFLICT);
		}

		_ladoService.removeLado(idLado);
		return new ResponseEntity(HttpStatus.OK);



	}

}
