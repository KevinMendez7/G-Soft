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
import com.scm.gsoft.domain.cxc.Emisores;
import com.scm.gsoft.service.cxc.EmisoresService;

@Controller
@RequestMapping("/v1/cxc")
public class EmisoresController {

	@Autowired
	private EmisoresService _emisoresService;

	//GET
	@RequestMapping(value = "/Emisores/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Emisores> getEmisoresById(@PathVariable("id") Long idEmisores){

		if(idEmisores == null || idEmisores <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Emisores emisores = _emisoresService.getEmisoresById(idEmisores);
		if(emisores == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Emisores>(emisores, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Emisores", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Emisores>> getEmisoresByName(@RequestParam(value = "name", required = false) String name){

		List<Emisores> emisoresList = new ArrayList<>();

		if(name == null) {

			emisoresList = _emisoresService.getEmisoresList();

			if(emisoresList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Emisores>>(emisoresList, HttpStatus.OK);

			}

		} else {

			Emisores emisores = _emisoresService.getEmisoresByName(name);

			if(emisores == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			emisoresList.add(emisores);
			return new ResponseEntity<List<Emisores>>(emisoresList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Emisores", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createEmisores(@RequestBody Emisores emisores, UriComponentsBuilder uriComponentsBuilder){

		if(emisores.getNombre().equals(null)||emisores.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_emisoresService.getEmisoresByName(emisores.getNombre()) != null) {

			return new ResponseEntity("The Emisores already exist", HttpStatus.CONFLICT);

		}

		_emisoresService.createEmisores(emisores);
		Emisores newEmisores = _emisoresService.getEmisoresByName(emisores.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Emisores/{id}")
				.buildAndExpand(newEmisores.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Emisores/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Emisores> updateEmisores(@PathVariable("id") Long idEmisores, @RequestBody Emisores emisores){

		if(idEmisores == null || idEmisores <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Emisores newEmisores = _emisoresService.getEmisoresById(idEmisores);
		if(newEmisores == null) {

			return new ResponseEntity("There's no Emisores with the id", HttpStatus.CONFLICT);

		}

		newEmisores.setCodigo(emisores.getCodigo());
		newEmisores.setNombre(emisores.getNombre());
		newEmisores.setUsuario(emisores.getUsuario());
		newEmisores.setStatReg(emisores.getStatReg());

		_emisoresService.updateEmisores(newEmisores);
		return new ResponseEntity<Emisores>(newEmisores, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Emisores/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteEmisoresById(@PathVariable("id") Long idEmisores){

		if(idEmisores == null || idEmisores <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Emisores emisores = _emisoresService.getEmisoresById(idEmisores);
		if(emisores == null) {

			return new ResponseEntity("Can't remove an inexistent Emisores", HttpStatus.CONFLICT);
		}

		_emisoresService.removeEmisores(idEmisores);
		return new ResponseEntity(HttpStatus.OK);



	}

}
