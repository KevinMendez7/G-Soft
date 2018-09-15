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
import com.scm.gsoft.domain.cxc.Detalle;
import com.scm.gsoft.service.cxc.DetalleService;

@Controller
@RequestMapping("/v1/cxc")
public class DetalleController {

	@Autowired
	private DetalleService _detalleService;

	//GET
	@RequestMapping(value = "/Detalle/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Detalle> getDetalleById(@PathVariable("id") Long idDetalle){

		if(idDetalle == null || idDetalle <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Detalle detalle = _detalleService.getDetalleById(idDetalle);
		if(detalle == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Detalle>(detalle, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Detalle", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Detalle>> getDetalleByName(@RequestParam(value = "name", required = false) String name){

		List<Detalle> detalleList = new ArrayList<>();

		if(name == null) {

			detalleList = _detalleService.getDetalleList();

			if(detalleList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Detalle>>(detalleList, HttpStatus.OK);

			}

		} else {

			Detalle detalle = _detalleService.getDetalleByName(name);

			if(detalle == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			detalleList.add(detalle);
			return new ResponseEntity<List<Detalle>>(detalleList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Detalle", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createDetalle(@RequestBody Detalle detalle, UriComponentsBuilder uriComponentsBuilder){

		if(detalle.getRegistro().equals(null)||detalle.getRegistro().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_detalleService.getDetalleByName(detalle.getRegistro()) != null) {

			return new ResponseEntity("The Detalle already exist", HttpStatus.CONFLICT);

		}

		_detalleService.createDetalle(detalle);
		Detalle newDetalle = _detalleService.getDetalleByName(detalle.getRegistro());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Detalle/{id}")
				.buildAndExpand(newDetalle.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Detalle/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Detalle> updateDetalle(@PathVariable("id") Long idDetalle, @RequestBody Detalle detalle){

		if(idDetalle == null || idDetalle <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Detalle newDetalle = _detalleService.getDetalleById(idDetalle);
		if(newDetalle == null) {

			return new ResponseEntity("There's no Detalle with the id", HttpStatus.CONFLICT);

		}
		
		newDetalle.setRegistro(detalle.getRegistro());
		newDetalle.setUsuario(detalle.getUsuario());
		newDetalle.setStatReg(detalle.getStatReg());

		_detalleService.updateDetalle(newDetalle);
		return new ResponseEntity<Detalle>(newDetalle, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Detalle/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteDetalleById(@PathVariable("id") Long idDetalle){

		if(idDetalle == null || idDetalle <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Detalle detalle = _detalleService.getDetalleById(idDetalle);
		if(detalle == null) {

			return new ResponseEntity("Can't remove an inexistent Detalle", HttpStatus.CONFLICT);
		}

		_detalleService.removeDetalle(idDetalle);
		return new ResponseEntity(HttpStatus.OK);



	}

}
