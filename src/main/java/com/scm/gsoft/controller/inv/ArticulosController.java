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
import com.scm.gsoft.domain.inv.Articulos;
import com.scm.gsoft.service.inv.ArticulosService;

@Controller
@RequestMapping("/v1/inv")
public class ArticulosController {

	@Autowired
	private ArticulosService _articulosService;

	//GET
	@RequestMapping(value = "/Articulos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Articulos> getArticulosById(@PathVariable("id") Long idArticulos){

		if(idArticulos == null || idArticulos <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Articulos articulos = _articulosService.getArticulosById(idArticulos);
		if(articulos == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Articulos>(articulos, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Articulos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Articulos>> getArticulosByName(@RequestParam(value = "name", required = false) String name){

		List<Articulos> articulosList = new ArrayList<>();

		if(name == null) {

			articulosList = _articulosService.getArticulosList();

			if(articulosList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Articulos>>(articulosList, HttpStatus.OK);

			}

		} else {

			Articulos articulos = _articulosService.getArticulosByName(name);

			if(articulos == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			articulosList.add(articulos);
			return new ResponseEntity<List<Articulos>>(articulosList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Articulos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createArticulos(@RequestBody Articulos articulos, UriComponentsBuilder uriComponentsBuilder){

		if(articulos.getNombre().equals(null)||articulos.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_articulosService.getArticulosByName(articulos.getNombre()) != null) {

			return new ResponseEntity("The Articulos already exist", HttpStatus.CONFLICT);

		}

		_articulosService.createArticulos(articulos);
		Articulos newArticulos = _articulosService.getArticulosByName(articulos.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Articulos/{id}")
				.buildAndExpand(newArticulos.getIdArticulos())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Articulos/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Articulos> updateArticulos(@PathVariable("id") Long idArticulos, @RequestBody Articulos articulos){

		if(idArticulos == null || idArticulos <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Articulos newArticulos = _articulosService.getArticulosById(idArticulos);
		if(newArticulos == null) {

			return new ResponseEntity("There's no Articulos with the id", HttpStatus.CONFLICT);

		}

		newArticulos.setCodigo(articulos.getCodigo());
		newArticulos.setNombre(articulos.getNombre());
		newArticulos.setUsuario(articulos.getUsuario());
		newArticulos.setStatReg(articulos.getStatReg());

		_articulosService.updateArticulos(newArticulos);
		return new ResponseEntity<Articulos>(newArticulos, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Articulos/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteArticulosById(@PathVariable("id") Long idArticulos){

		if(idArticulos == null || idArticulos <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Articulos articulos = _articulosService.getArticulosById(idArticulos);
		if(articulos == null) {

			return new ResponseEntity("Can't remove an inexistent Articulos", HttpStatus.CONFLICT);
		}

		_articulosService.removeArticulos(idArticulos);
		return new ResponseEntity(HttpStatus.OK);



	}

}
