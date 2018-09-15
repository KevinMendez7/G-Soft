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
import com.scm.gsoft.domain.inv.SubGrupos;
import com.scm.gsoft.service.inv.SubGruposService;

@Controller
@RequestMapping("/v1/inv")
public class SubGruposController {

	@Autowired
	private SubGruposService _subGruposService;

	//GET
	@RequestMapping(value = "/SubGrupos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<SubGrupos> getSubGruposById(@PathVariable("id") Long idSubGrupos){

		if(idSubGrupos == null || idSubGrupos <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		SubGrupos subGrupos = _subGruposService.getSubGruposById(idSubGrupos);
		if(subGrupos == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<SubGrupos>(subGrupos, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/SubGrupos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<SubGrupos>> getSubGruposByName(@RequestParam(value = "name", required = false) String name){

		List<SubGrupos> subGruposList = new ArrayList<>();

		if(name == null) {

			subGruposList = _subGruposService.getSubGruposList();

			if(subGruposList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<SubGrupos>>(subGruposList, HttpStatus.OK);

			}

		} else {

			SubGrupos subGrupos = _subGruposService.getSubGruposByName(name);

			if(subGrupos == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			subGruposList.add(subGrupos);
			return new ResponseEntity<List<SubGrupos>>(subGruposList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/SubGrupos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createSubGrupos(@RequestBody SubGrupos subGrupos, UriComponentsBuilder uriComponentsBuilder){

		if(subGrupos.getSubGrupos().equals(null)||subGrupos.getSubGrupos().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_subGruposService.getSubGruposByName(subGrupos.getSubGrupos()) != null) {

			return new ResponseEntity("The SubGrupos already exist", HttpStatus.CONFLICT);

		}

		_subGruposService.createSubGrupos(subGrupos);
		SubGrupos newSubGrupos = _subGruposService.getSubGruposByName(subGrupos.getSubGrupos());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/SubGrupos/{id}")
				.buildAndExpand(newSubGrupos.getIdSubGrupos())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/SubGrupos/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<SubGrupos> updateSubGrupos(@PathVariable("id") Long idSubGrupos, @RequestBody SubGrupos subGrupos){

		if(idSubGrupos == null || idSubGrupos <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		SubGrupos newSubGrupos = _subGruposService.getSubGruposById(idSubGrupos);
		if(newSubGrupos == null) {

			return new ResponseEntity("There's no SubGrupos with the id", HttpStatus.CONFLICT);

		}

		newSubGrupos.setSubGrupos(subGrupos.getSubGrupos());

		_subGruposService.updateSubGrupos(newSubGrupos);
		return new ResponseEntity<SubGrupos>(newSubGrupos, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/SubGrupos/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteSubGruposById(@PathVariable("id") Long idSubGrupos){

		if(idSubGrupos == null || idSubGrupos <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		SubGrupos subGrupos = _subGruposService.getSubGruposById(idSubGrupos);
		if(subGrupos == null) {

			return new ResponseEntity("Can't remove an inexistent SubGrupos", HttpStatus.CONFLICT);
		}

		_subGruposService.removeSubGrupos(idSubGrupos);
		return new ResponseEntity(HttpStatus.OK);



	}

}
