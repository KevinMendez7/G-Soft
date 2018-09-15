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
import com.scm.gsoft.domain.cxc.Recibos;
import com.scm.gsoft.service.cxc.RecibosService;

@Controller
@RequestMapping("/v1/cxc")
public class RecibosController {

	@Autowired
	private RecibosService _recibosService;

	//GET
	@RequestMapping(value = "/Recibos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Recibos> getRecibosById(@PathVariable("id") Long idRecibos){

		if(idRecibos == null || idRecibos <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Recibos recibos = _recibosService.getRecibosById(idRecibos);
		if(recibos == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Recibos>(recibos, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Recibos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Recibos>> getRecibosByName(@RequestParam(value = "name", required = false) String name){

		List<Recibos> recibosList = new ArrayList<>();

		if(name == null) {

			recibosList = _recibosService.getRecibosList();

			if(recibosList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Recibos>>(recibosList, HttpStatus.OK);

			}

		} else {

			Recibos recibos = _recibosService.getRecibosByName(name);

			if(recibos == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			recibosList.add(recibos);
			return new ResponseEntity<List<Recibos>>(recibosList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Recibos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createRecibos(@RequestBody Recibos recibos, UriComponentsBuilder uriComponentsBuilder){

		if(recibos.getCodigo().equals(null)||recibos.getCodigo().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_recibosService.getRecibosByName(recibos.getCodigo()) != null) {

			return new ResponseEntity("The Recibos already exist", HttpStatus.CONFLICT);

		}

		_recibosService.createRecibos(recibos);
		Recibos newRecibos = _recibosService.getRecibosByName(recibos.getCodigo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Recibos/{id}")
				.buildAndExpand(newRecibos.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Recibos/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Recibos> updateRecibos(@PathVariable("id") Long idRecibos, @RequestBody Recibos recibos){

		if(idRecibos == null || idRecibos <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Recibos newRecibos = _recibosService.getRecibosById(idRecibos);
		if(newRecibos == null) {

			return new ResponseEntity("There's no Recibos with the id", HttpStatus.CONFLICT);

		}

		newRecibos.setCodigo(recibos.getCodigo());		
		newRecibos.setUsuario(recibos.getUsuario());
		newRecibos.setStatReg(recibos.getStatReg());

		_recibosService.updateRecibos(newRecibos);
		return new ResponseEntity<Recibos>(newRecibos, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Recibos/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteRecibosById(@PathVariable("id") Long idRecibos){

		if(idRecibos == null || idRecibos <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Recibos recibos = _recibosService.getRecibosById(idRecibos);
		if(recibos == null) {

			return new ResponseEntity("Can't remove an inexistent Recibos", HttpStatus.CONFLICT);
		}

		_recibosService.removeRecibos(idRecibos);
		return new ResponseEntity(HttpStatus.OK);



	}

}
