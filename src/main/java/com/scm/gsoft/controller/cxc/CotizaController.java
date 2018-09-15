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
import com.scm.gsoft.domain.cxc.Cotiza;
import com.scm.gsoft.service.cxc.CotizaService;

@Controller
@RequestMapping("/v1/cxc")
public class CotizaController {

	@Autowired
	private CotizaService _cotizaService;

	//GET
	@RequestMapping(value = "/Cotiza/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Cotiza> getCotizaById(@PathVariable("id") Long idCotiza){

		if(idCotiza == null || idCotiza <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Cotiza cotiza = _cotizaService.getCotizaById(idCotiza);
		if(cotiza == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Cotiza>(cotiza, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Cotiza", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Cotiza>> getCotizaByName(@RequestParam(value = "name", required = false) String name){

		List<Cotiza> cotizaList = new ArrayList<>();

		if(name == null) {

			cotizaList = _cotizaService.getCotizaList();

			if(cotizaList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Cotiza>>(cotizaList, HttpStatus.OK);

			}

		} else {

			Cotiza cotiza = _cotizaService.getCotizaByName(name);

			if(cotiza == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			cotizaList.add(cotiza);
			return new ResponseEntity<List<Cotiza>>(cotizaList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Cotiza", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCotiza(@RequestBody Cotiza cotiza, UriComponentsBuilder uriComponentsBuilder){

		if(cotiza.getNumDcto().equals(null)||cotiza.getNumDcto().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_cotizaService.getCotizaByName(cotiza.getNumDcto()) != null) {

			return new ResponseEntity("The Cotiza already exist", HttpStatus.CONFLICT);

		}

		_cotizaService.createCotiza(cotiza);
		Cotiza newCotiza = _cotizaService.getCotizaByName(cotiza.getNumDcto());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Cotiza/{id}")
				.buildAndExpand(newCotiza.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Cotiza/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Cotiza> updateCotiza(@PathVariable("id") Long idCotiza, @RequestBody Cotiza cotiza){

		if(idCotiza == null || idCotiza <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Cotiza newCotiza = _cotizaService.getCotizaById(idCotiza);
		if(newCotiza == null) {

			return new ResponseEntity("There's no Cotiza with the id", HttpStatus.CONFLICT);

		}

		newCotiza.setDescripcion(cotiza.getDescripcion());		

		_cotizaService.updateCotiza(newCotiza);
		return new ResponseEntity<Cotiza>(newCotiza, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Cotiza/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteCotizaById(@PathVariable("id") Long idCotiza){

		if(idCotiza == null || idCotiza <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Cotiza cotiza = _cotizaService.getCotizaById(idCotiza);
		if(cotiza == null) {

			return new ResponseEntity("Can't remove an inexistent Cotiza", HttpStatus.CONFLICT);
		}

		_cotizaService.removeCotiza(idCotiza);
		return new ResponseEntity(HttpStatus.OK);



	}

}
