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
import com.scm.gsoft.domain.inv.Grupos;
import com.scm.gsoft.service.inv.GruposService;

@Controller
@RequestMapping("/v1/inv")
public class GruposController {

	@Autowired
	private GruposService _gruposService;

	//GET
	@RequestMapping(value = "/Grupos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Grupos> getGruposById(@PathVariable("id") Long idGrupos){

		if(idGrupos == null || idGrupos <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Grupos grupos = _gruposService.getGruposById(idGrupos);
		if(grupos == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Grupos>(grupos, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Grupos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Grupos>> getGruposByName(@RequestParam(value = "name", required = false) String name){

		List<Grupos> gruposList = new ArrayList<>();

		if(name == null) {

			gruposList = _gruposService.getGruposList();

			if(gruposList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Grupos>>(gruposList, HttpStatus.OK);

			}

		} else {

			Grupos grupos = _gruposService.getGruposByName(name);

			if(grupos == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			gruposList.add(grupos);
			return new ResponseEntity<List<Grupos>>(gruposList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Grupos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createGrupos(@RequestBody Grupos grupos, UriComponentsBuilder uriComponentsBuilder){

		if(grupos.getEncabeza().equals(null)||grupos.getEncabeza().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_gruposService.getGruposByName(grupos.getEncabeza()) != null) {

			return new ResponseEntity("The Grupos already exist", HttpStatus.CONFLICT);

		}

		_gruposService.createGrupos(grupos);
		Grupos newGrupos = _gruposService.getGruposByName(grupos.getEncabeza());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Grupos/{id}")
				.buildAndExpand(newGrupos.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Grupos/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Grupos> updateGrupos(@PathVariable("id") Long idGrupos, @RequestBody Grupos grupos){

		if(idGrupos == null || idGrupos <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Grupos newGrupos = _gruposService.getGruposById(idGrupos);
		if(newGrupos == null) {

			return new ResponseEntity("There's no Grupos with the id", HttpStatus.CONFLICT);

		}

		newGrupos.setUsuario(grupos.getUsuario());
		newGrupos.setStatReg(grupos.getStatReg());

		_gruposService.updateGrupos(newGrupos);
		return new ResponseEntity<Grupos>(newGrupos, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Grupos/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteGruposById(@PathVariable("id") Long idGrupos){

		if(idGrupos == null || idGrupos <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Grupos grupos = _gruposService.getGruposById(idGrupos);
		if(grupos == null) {

			return new ResponseEntity("Can't remove an inexistent Grupos", HttpStatus.CONFLICT);
		}

		_gruposService.removeGrupos(idGrupos);
		return new ResponseEntity(HttpStatus.OK);



	}

}
