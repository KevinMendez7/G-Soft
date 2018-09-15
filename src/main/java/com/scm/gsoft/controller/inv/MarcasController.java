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
import com.scm.gsoft.domain.inv.Marcas;
import com.scm.gsoft.service.inv.MarcasService;

@Controller
@RequestMapping("/v1/inv")
public class MarcasController {

	@Autowired
	private MarcasService _marcasService;

	//GET
	@RequestMapping(value = "/Marcas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Marcas> getMarcasById(@PathVariable("id") Long idMarcas){

		if(idMarcas == null || idMarcas <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Marcas marcas = _marcasService.getMarcasById(idMarcas);
		if(marcas == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Marcas>(marcas, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Marcas", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Marcas>> getMarcasByName(@RequestParam(value = "name", required = false) String name){

		List<Marcas> marcasList = new ArrayList<>();

		if(name == null) {

			marcasList = _marcasService.getMarcasList();

			if(marcasList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Marcas>>(marcasList, HttpStatus.OK);

			}

		} else {

			Marcas marcas = _marcasService.getMarcasByName(name);

			if(marcas == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			marcasList.add(marcas);
			return new ResponseEntity<List<Marcas>>(marcasList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Marcas", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createMarcas(@RequestBody Marcas marcas, UriComponentsBuilder uriComponentsBuilder){

		if(marcas.getCodMarca().equals(null)||marcas.getCodMarca().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_marcasService.getMarcasByName(marcas.getCodMarca()) != null) {

			return new ResponseEntity("The Marcas already exist", HttpStatus.CONFLICT);

		}

		_marcasService.createMarcas(marcas);
		Marcas newMarcas = _marcasService.getMarcasByName(marcas.getCodMarca());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Marcas/{id}")
				.buildAndExpand(newMarcas.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Marcas/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Marcas> updateMarcas(@PathVariable("id") Long idMarcas, @RequestBody Marcas marcas){

		if(idMarcas == null || idMarcas <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Marcas newMarcas = _marcasService.getMarcasById(idMarcas);
		if(newMarcas == null) {

			return new ResponseEntity("There's no Marcas with the id", HttpStatus.CONFLICT);

		}

		newMarcas.setUsuario(marcas.getUsuario());
		newMarcas.setStatReg(marcas.getStatReg());

		_marcasService.updateMarcas(newMarcas);
		return new ResponseEntity<Marcas>(newMarcas, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Marcas/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteMarcasById(@PathVariable("id") Long idMarcas){

		if(idMarcas == null || idMarcas <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Marcas marcas = _marcasService.getMarcasById(idMarcas);
		if(marcas == null) {

			return new ResponseEntity("Can't remove an inexistent Marcas", HttpStatus.CONFLICT);
		}

		_marcasService.removeMarcas(idMarcas);
		return new ResponseEntity(HttpStatus.OK);



	}

}
