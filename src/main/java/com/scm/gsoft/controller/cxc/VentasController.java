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
import com.scm.gsoft.domain.cxc.Ventas;
import com.scm.gsoft.service.cxc.VentasService;

@Controller
@RequestMapping("/v1/cxc")
public class VentasController {

	@Autowired
	private VentasService _ventasService;

	//GET
	@RequestMapping(value = "/Ventas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Ventas> getVentasById(@PathVariable("id") Long idVentas){

		if(idVentas == null || idVentas <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Ventas ventas = _ventasService.getVentasById(idVentas);
		if(ventas == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Ventas>(ventas, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Ventas", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Ventas>> getVentasByName(@RequestParam(value = "name", required = false) String name){

		List<Ventas> ventasList = new ArrayList<>();

		if(name == null) {

			ventasList = _ventasService.getVentasList();

			if(ventasList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Ventas>>(ventasList, HttpStatus.OK);

			}

		} else {

			Ventas ventas = _ventasService.getVentasByName(name);

			if(ventas == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			ventasList.add(ventas);
			return new ResponseEntity<List<Ventas>>(ventasList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Ventas", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createVentas(@RequestBody Ventas ventas, UriComponentsBuilder uriComponentsBuilder){

		if(ventas.getCodArt().equals(null)||ventas.getCodArt().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_ventasService.getVentasByName(ventas.getCodArt()) != null) {

			return new ResponseEntity("The Ventas already exist", HttpStatus.CONFLICT);

		}

		_ventasService.createVentas(ventas);
		Ventas newVentas = _ventasService.getVentasByName(ventas.getCodArt());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Ventas/{id}")
				.buildAndExpand(newVentas.getIdVentas())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Ventas/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Ventas> updateVentas(@PathVariable("id") Long idVentas, @RequestBody Ventas ventas){

		if(idVentas == null || idVentas <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Ventas newVentas = _ventasService.getVentasById(idVentas);
		if(newVentas == null) {

			return new ResponseEntity("There's no Ventas with the id", HttpStatus.CONFLICT);

		}

		newVentas.setCodArt(ventas.getCodArt());

		_ventasService.updateVentas(newVentas);
		return new ResponseEntity<Ventas>(newVentas, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Ventas/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteVentasById(@PathVariable("id") Long idVentas){

		if(idVentas == null || idVentas <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Ventas ventas = _ventasService.getVentasById(idVentas);
		if(ventas == null) {

			return new ResponseEntity("Can't remove an inexistent Ventas", HttpStatus.CONFLICT);
		}

		_ventasService.removeVentas(idVentas);
		return new ResponseEntity(HttpStatus.OK);



	}

}
