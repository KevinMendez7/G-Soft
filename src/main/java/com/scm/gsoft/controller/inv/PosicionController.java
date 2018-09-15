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
import com.scm.gsoft.domain.inv.Posicion;
import com.scm.gsoft.service.inv.PosicionService;

@Controller
@RequestMapping("/v1/inv")
public class PosicionController {

	@Autowired
	private PosicionService _posicionService;

	//GET
	@RequestMapping(value = "/Posicion/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Posicion> getPosicionById(@PathVariable("id") Long idPosicion){

		if(idPosicion == null || idPosicion <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Posicion posicion = _posicionService.getPosicionById(idPosicion);
		if(posicion == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Posicion>(posicion, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Posicion", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Posicion>> getPosicionByName(@RequestParam(value = "name", required = false) String name){

		List<Posicion> posicionList = new ArrayList<>();

		if(name == null) {

			posicionList = _posicionService.getPosicionList();

			if(posicionList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Posicion>>(posicionList, HttpStatus.OK);

			}

		} else {

			Posicion posicion = _posicionService.getPosicionByName(name);

			if(posicion == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			posicionList.add(posicion);
			return new ResponseEntity<List<Posicion>>(posicionList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Posicion", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createPosicion(@RequestBody Posicion posicion, UriComponentsBuilder uriComponentsBuilder){

		if(posicion.getCodPosicion().equals(null)||posicion.getCodPosicion().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_posicionService.getPosicionByName(posicion.getCodPosicion()) != null) {

			return new ResponseEntity("The Posicion already exist", HttpStatus.CONFLICT);

		}

		_posicionService.createPosicion(posicion);
		Posicion newPosicion = _posicionService.getPosicionByName(posicion.getCodPosicion());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Posicion/{id}")
				.buildAndExpand(newPosicion.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Posicion/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Posicion> updatePosicion(@PathVariable("id") Long idPosicion, @RequestBody Posicion posicion){

		if(idPosicion == null || idPosicion <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Posicion newPosicion = _posicionService.getPosicionById(idPosicion);
		if(newPosicion == null) {

			return new ResponseEntity("There's no Posicion with the id", HttpStatus.CONFLICT);

		}

		newPosicion.setUsuario(posicion.getUsuario());
		newPosicion.setStatReg(posicion.getStatReg());

		_posicionService.updatePosicion(newPosicion);
		return new ResponseEntity<Posicion>(newPosicion, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Posicion/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deletePosicionById(@PathVariable("id") Long idPosicion){

		if(idPosicion == null || idPosicion <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Posicion posicion = _posicionService.getPosicionById(idPosicion);
		if(posicion == null) {

			return new ResponseEntity("Can't remove an inexistent Posicion", HttpStatus.CONFLICT);
		}

		_posicionService.removePosicion(idPosicion);
		return new ResponseEntity(HttpStatus.OK);



	}

}
