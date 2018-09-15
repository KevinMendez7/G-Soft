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
import com.scm.gsoft.domain.cxc.Modulos;
import com.scm.gsoft.service.cxc.ModulosService;

@Controller("ModulosControllerCxc")
@RequestMapping("/v1/cxc")
public class ModulosController {

	@Autowired
	@Qualifier("ModulosServiceCxc")
	private ModulosService _modulosService;

	//GET
	@RequestMapping(value = "/Modulos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Modulos> getModulosById(@PathVariable("id") Long idModulos){

		if(idModulos == null || idModulos <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Modulos modulos = _modulosService.getModulosById(idModulos);
		if(modulos == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Modulos>(modulos, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Modulos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Modulos>> getModulosByName(@RequestParam(value = "name", required = false) String name){

		List<Modulos> modulosList = new ArrayList<>();

		if(name == null) {

			modulosList = _modulosService.getModulosList();

			if(modulosList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Modulos>>(modulosList, HttpStatus.OK);

			}

		} else {

			Modulos modulos = _modulosService.getModulosByName(name);

			if(modulos == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			modulosList.add(modulos);
			return new ResponseEntity<List<Modulos>>(modulosList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Modulos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createModulos(@RequestBody Modulos modulos, UriComponentsBuilder uriComponentsBuilder){

		if(modulos.getNombre().equals(null)||modulos.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_modulosService.getModulosByName(modulos.getNombre()) != null) {

			return new ResponseEntity("The Modulos already exist", HttpStatus.CONFLICT);

		}

		_modulosService.createModulos(modulos);
		Modulos newModulos = _modulosService.getModulosByName(modulos.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Modulos/{id}")
				.buildAndExpand(newModulos.getIdModulos())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Modulos/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Modulos> updateModulos(@PathVariable("id") Long idModulos, @RequestBody Modulos modulos){

		if(idModulos == null || idModulos <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Modulos newModulos = _modulosService.getModulosById(idModulos);
		if(newModulos == null) {

			return new ResponseEntity("There's no Modulos with the id", HttpStatus.CONFLICT);

		}

		newModulos.setCodigo(modulos.getCodigo());
		newModulos.setNombre(modulos.getNombre());

		_modulosService.updateModulos(newModulos);
		return new ResponseEntity<Modulos>(newModulos, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Modulos/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteModulosById(@PathVariable("id") Long idModulos){

		if(idModulos == null || idModulos <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Modulos modulos = _modulosService.getModulosById(idModulos);
		if(modulos == null) {

			return new ResponseEntity("Can't remove an inexistent Modulos", HttpStatus.CONFLICT);
		}

		_modulosService.removeModulos(idModulos);
		return new ResponseEntity(HttpStatus.OK);



	}

}
