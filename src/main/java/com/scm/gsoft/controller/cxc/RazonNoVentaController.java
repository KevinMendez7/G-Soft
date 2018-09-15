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
import com.scm.gsoft.domain.cxc.RazonNoVenta;
import com.scm.gsoft.service.cxc.RazonNoVentaService;

@Controller
@RequestMapping("/v1/cxc")
public class RazonNoVentaController {

	@Autowired
	private RazonNoVentaService _razonNoVentaService;

	//GET
	@RequestMapping(value = "/RazonNoVenta/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<RazonNoVenta> getRazonNoVentaById(@PathVariable("id") Long idRazonNoVenta){

		if(idRazonNoVenta == null || idRazonNoVenta <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		RazonNoVenta razonNoVenta = _razonNoVentaService.getRazonNoVentaById(idRazonNoVenta);
		if(razonNoVenta == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<RazonNoVenta>(razonNoVenta, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/RazonNoVenta", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<RazonNoVenta>> getRazonNoVentaByName(@RequestParam(value = "name", required = false) String name){

		List<RazonNoVenta> razonNoVentaList = new ArrayList<>();

		if(name == null) {

			razonNoVentaList = _razonNoVentaService.getRazonNoVentaList();

			if(razonNoVentaList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<RazonNoVenta>>(razonNoVentaList, HttpStatus.OK);

			}

		} else {

			RazonNoVenta razonNoVenta = _razonNoVentaService.getRazonNoVentaByName(name);

			if(razonNoVenta == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			razonNoVentaList.add(razonNoVenta);
			return new ResponseEntity<List<RazonNoVenta>>(razonNoVentaList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/RazonNoVenta", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createRazonNoVenta(@RequestBody RazonNoVenta razonNoVenta, UriComponentsBuilder uriComponentsBuilder){

		if(razonNoVenta.getUsuario().equals(null)||razonNoVenta.getUsuario().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_razonNoVentaService.getRazonNoVentaByName(razonNoVenta.getUsuario()) != null) {

			return new ResponseEntity("The RazonNoVenta already exist", HttpStatus.CONFLICT);

		}

		_razonNoVentaService.createRazonNoVenta(razonNoVenta);
		RazonNoVenta newRazonNoVenta = _razonNoVentaService.getRazonNoVentaByName(razonNoVenta.getUsuario());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/RazonNoVenta/{id}")
				.buildAndExpand(newRazonNoVenta.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/RazonNoVenta/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<RazonNoVenta> updateRazonNoVenta(@PathVariable("id") Long idRazonNoVenta, @RequestBody RazonNoVenta razonNoVenta){

		if(idRazonNoVenta == null || idRazonNoVenta <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		RazonNoVenta newRazonNoVenta = _razonNoVentaService.getRazonNoVentaById(idRazonNoVenta);
		if(newRazonNoVenta == null) {

			return new ResponseEntity("There's no RazonNoVenta with the id", HttpStatus.CONFLICT);

		}

		newRazonNoVenta.setUsuario(razonNoVenta.getUsuario());
		newRazonNoVenta.setStatReg(razonNoVenta.getStatReg());

		_razonNoVentaService.updateRazonNoVenta(newRazonNoVenta);
		return new ResponseEntity<RazonNoVenta>(newRazonNoVenta, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/RazonNoVenta/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteRazonNoVentaById(@PathVariable("id") Long idRazonNoVenta){

		if(idRazonNoVenta == null || idRazonNoVenta <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		RazonNoVenta razonNoVenta = _razonNoVentaService.getRazonNoVentaById(idRazonNoVenta);
		if(razonNoVenta == null) {

			return new ResponseEntity("Can't remove an inexistent RazonNoVenta", HttpStatus.CONFLICT);
		}

		_razonNoVentaService.removeRazonNoVenta(idRazonNoVenta);
		return new ResponseEntity(HttpStatus.OK);



	}

}
