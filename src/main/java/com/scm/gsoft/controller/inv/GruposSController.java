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
import com.scm.gsoft.domain.inv.GruposS;
import com.scm.gsoft.service.inv.GruposSService;

@Controller
@RequestMapping("/v1/inv")
public class GruposSController {

	@Autowired
	private GruposSService _gruposSService;

	//GET
	@RequestMapping(value = "/GruposS/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<GruposS> getGruposSById(@PathVariable("id") Long idGruposS){

		if(idGruposS == null || idGruposS <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		GruposS gruposS = _gruposSService.getGruposSById(idGruposS);
		if(gruposS == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<GruposS>(gruposS, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/GruposS", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<GruposS>> getGruposSByName(@RequestParam(value = "name", required = false) String name){

		List<GruposS> gruposSList = new ArrayList<>();

		if(name == null) {

			gruposSList = _gruposSService.getGruposSList();

			if(gruposSList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<GruposS>>(gruposSList, HttpStatus.OK);

			}

		} else {

			GruposS gruposS = _gruposSService.getGruposSByName(name);

			if(gruposS == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			gruposSList.add(gruposS);
			return new ResponseEntity<List<GruposS>>(gruposSList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/GruposS", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createGruposS(@RequestBody GruposS gruposS, UriComponentsBuilder uriComponentsBuilder){

		if(gruposS.getCodigo().equals(null)||gruposS.getCodigo().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_gruposSService.getGruposSByName(gruposS.getCodigo()) != null) {

			return new ResponseEntity("The GruposS already exist", HttpStatus.CONFLICT);

		}

		_gruposSService.createGruposS(gruposS);
		GruposS newGruposS = _gruposSService.getGruposSByName(gruposS.getCodigo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/GruposS/{id}")
				.buildAndExpand(newGruposS.getIdGruposS())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/GruposS/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<GruposS> updateGruposS(@PathVariable("id") Long idGruposS, @RequestBody GruposS gruposS){

		if(idGruposS == null || idGruposS <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		GruposS newGruposS = _gruposSService.getGruposSById(idGruposS);
		if(newGruposS == null) {

			return new ResponseEntity("There's no GruposS with the id", HttpStatus.CONFLICT);

		}

		newGruposS.setCodigo(gruposS.getCodigo());

		_gruposSService.updateGruposS(newGruposS);
		return new ResponseEntity<GruposS>(newGruposS, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/GruposS/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteGruposSById(@PathVariable("id") Long idGruposS){

		if(idGruposS == null || idGruposS <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		GruposS gruposS = _gruposSService.getGruposSById(idGruposS);
		if(gruposS == null) {

			return new ResponseEntity("Can't remove an inexistent GruposS", HttpStatus.CONFLICT);
		}

		_gruposSService.removeGruposS(idGruposS);
		return new ResponseEntity(HttpStatus.OK);



	}

}
