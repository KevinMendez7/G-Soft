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
import com.scm.gsoft.domain.inv.Linea;
import com.scm.gsoft.service.inv.LineaService;

@Controller
@RequestMapping("/v1/inv")
public class LineaController {

	@Autowired
	private LineaService _lineaService;

	//GET
	@RequestMapping(value = "/Linea/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Linea> getLineaById(@PathVariable("id") Long idLinea){

		if(idLinea == null || idLinea <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Linea linea = _lineaService.getLineaById(idLinea);
		if(linea == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Linea>(linea, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Linea", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Linea>> getLineaByName(@RequestParam(value = "name", required = false) String name){

		List<Linea> lineaList = new ArrayList<>();

		if(name == null) {

			lineaList = _lineaService.getLineaList();

			if(lineaList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Linea>>(lineaList, HttpStatus.OK);

			}

		} else {

			Linea linea = _lineaService.getLineaByName(name);

			if(linea == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			lineaList.add(linea);
			return new ResponseEntity<List<Linea>>(lineaList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Linea", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createLinea(@RequestBody Linea linea, UriComponentsBuilder uriComponentsBuilder){

		if(linea.getCodLinea().equals(null)||linea.getCodLinea().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_lineaService.getLineaByName(linea.getCodLinea()) != null) {

			return new ResponseEntity("The Linea already exist", HttpStatus.CONFLICT);

		}

		_lineaService.createLinea(linea);
		Linea newLinea = _lineaService.getLineaByName(linea.getCodLinea());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Linea/{id}")
				.buildAndExpand(newLinea.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Linea/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Linea> updateLinea(@PathVariable("id") Long idLinea, @RequestBody Linea linea){

		if(idLinea == null || idLinea <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Linea newLinea = _lineaService.getLineaById(idLinea);
		if(newLinea == null) {

			return new ResponseEntity("There's no Linea with the id", HttpStatus.CONFLICT);

		}

		newLinea.setUsuario(linea.getUsuario());
		newLinea.setStatReg(linea.getStatReg());

		_lineaService.updateLinea(newLinea);
		return new ResponseEntity<Linea>(newLinea, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Linea/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteLineaById(@PathVariable("id") Long idLinea){

		if(idLinea == null || idLinea <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Linea linea = _lineaService.getLineaById(idLinea);
		if(linea == null) {

			return new ResponseEntity("Can't remove an inexistent Linea", HttpStatus.CONFLICT);
		}

		_lineaService.removeLinea(idLinea);
		return new ResponseEntity(HttpStatus.OK);



	}

}
