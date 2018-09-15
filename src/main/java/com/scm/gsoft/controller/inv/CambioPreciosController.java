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
import com.scm.gsoft.domain.inv.CambioPrecios;
import com.scm.gsoft.service.inv.CambioPreciosService;

@Controller
@RequestMapping("/v1/inv")
public class CambioPreciosController {

	@Autowired
	private CambioPreciosService _cambioPreciosService;

	//GET
	@RequestMapping(value = "/CambioPrecios/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<CambioPrecios> getCambioPreciosById(@PathVariable("id") Long idCambioPrecios){

		if(idCambioPrecios == null || idCambioPrecios <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		CambioPrecios cambioPrecios = _cambioPreciosService.getCambioPreciosById(idCambioPrecios);
		if(cambioPrecios == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<CambioPrecios>(cambioPrecios, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/CambioPrecios", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<CambioPrecios>> getCambioPreciosByName(@RequestParam(value = "name", required = false) String name){

		List<CambioPrecios> cambioPreciosList = new ArrayList<>();

		if(name == null) {

			cambioPreciosList = _cambioPreciosService.getCambioPreciosList();

			if(cambioPreciosList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<CambioPrecios>>(cambioPreciosList, HttpStatus.OK);

			}

		} else {

			CambioPrecios cambioPrecios = _cambioPreciosService.getCambioPreciosByName(name);

			if(cambioPrecios == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			cambioPreciosList.add(cambioPrecios);
			return new ResponseEntity<List<CambioPrecios>>(cambioPreciosList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/CambioPrecios", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCambioPrecios(@RequestBody CambioPrecios cambioPrecios, UriComponentsBuilder uriComponentsBuilder){

		if(cambioPrecios.getNombre().equals(null)||cambioPrecios.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_cambioPreciosService.getCambioPreciosByName(cambioPrecios.getNombre()) != null) {

			return new ResponseEntity("The CambioPrecios already exist", HttpStatus.CONFLICT);

		}

		_cambioPreciosService.createCambioPrecios(cambioPrecios);
		CambioPrecios newCambioPrecios = _cambioPreciosService.getCambioPreciosByName(cambioPrecios.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/CambioPrecios/{id}")
				.buildAndExpand(newCambioPrecios.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/CambioPrecios/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<CambioPrecios> updateCambioPrecios(@PathVariable("id") Long idCambioPrecios, @RequestBody CambioPrecios cambioPrecios){

		if(idCambioPrecios == null || idCambioPrecios <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		CambioPrecios newCambioPrecios = _cambioPreciosService.getCambioPreciosById(idCambioPrecios);
		if(newCambioPrecios == null) {

			return new ResponseEntity("There's no CambioPrecios with the id", HttpStatus.CONFLICT);

		}

		newCambioPrecios.setNombre(cambioPrecios.getNombre());
		newCambioPrecios.setUsuario(cambioPrecios.getUsuario());
		newCambioPrecios.setStatReg(cambioPrecios.getStatReg());

		_cambioPreciosService.updateCambioPrecios(newCambioPrecios);
		return new ResponseEntity<CambioPrecios>(newCambioPrecios, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/CambioPrecios/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteCambioPreciosById(@PathVariable("id") Long idCambioPrecios){

		if(idCambioPrecios == null || idCambioPrecios <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		CambioPrecios cambioPrecios = _cambioPreciosService.getCambioPreciosById(idCambioPrecios);
		if(cambioPrecios == null) {

			return new ResponseEntity("Can't remove an inexistent CambioPrecios", HttpStatus.CONFLICT);
		}

		_cambioPreciosService.removeCambioPrecios(idCambioPrecios);
		return new ResponseEntity(HttpStatus.OK);



	}

}
