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
import com.scm.gsoft.domain.inv.ArticuloPadre;
import com.scm.gsoft.service.inv.ArticuloPadreService;

@Controller
@RequestMapping("/v1/inv")
public class ArticuloPadreController {

	@Autowired
	private ArticuloPadreService _articuloPadreService;

	//GET
	@RequestMapping(value = "/ArticuloPadre/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<ArticuloPadre> getArticuloPadreById(@PathVariable("id") Long idArticuloPadre){

		if(idArticuloPadre == null || idArticuloPadre <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		ArticuloPadre articuloPadre = _articuloPadreService.getArticuloPadreById(idArticuloPadre);
		if(articuloPadre == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<ArticuloPadre>(articuloPadre, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/ArticuloPadre", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<ArticuloPadre>> getArticuloPadreByName(@RequestParam(value = "name", required = false) String name){

		List<ArticuloPadre> articuloPadreList = new ArrayList<>();

		if(name == null) {

			articuloPadreList = _articuloPadreService.getArticuloPadreList();

			if(articuloPadreList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<ArticuloPadre>>(articuloPadreList, HttpStatus.OK);

			}

		} else {

			ArticuloPadre articuloPadre = _articuloPadreService.getArticuloPadreByName(name);

			if(articuloPadre == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			articuloPadreList.add(articuloPadre);
			return new ResponseEntity<List<ArticuloPadre>>(articuloPadreList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/ArticuloPadre", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createArticuloPadre(@RequestBody ArticuloPadre articuloPadre, UriComponentsBuilder uriComponentsBuilder){

		if(articuloPadre.getCodArtpadre().equals(null)||articuloPadre.getCodArtpadre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_articuloPadreService.getArticuloPadreByName(articuloPadre.getCodArtpadre()) != null) {

			return new ResponseEntity("The ArticuloPadre already exist", HttpStatus.CONFLICT);

		}

		_articuloPadreService.createArticuloPadre(articuloPadre);
		ArticuloPadre newArticuloPadre = _articuloPadreService.getArticuloPadreByName(articuloPadre.getCodArtpadre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/ArticuloPadre/{id}")
				.buildAndExpand(newArticuloPadre.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/ArticuloPadre/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<ArticuloPadre> updateArticuloPadre(@PathVariable("id") Long idArticuloPadre, @RequestBody ArticuloPadre articuloPadre){

		if(idArticuloPadre == null || idArticuloPadre <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		ArticuloPadre newArticuloPadre = _articuloPadreService.getArticuloPadreById(idArticuloPadre);
		if(newArticuloPadre == null) {

			return new ResponseEntity("There's no ArticuloPadre with the id", HttpStatus.CONFLICT);

		}

		newArticuloPadre.setUsuario(articuloPadre.getUsuario());
		newArticuloPadre.setStatReg(articuloPadre.getStatReg());

		_articuloPadreService.updateArticuloPadre(newArticuloPadre);
		return new ResponseEntity<ArticuloPadre>(newArticuloPadre, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/ArticuloPadre/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteArticuloPadreById(@PathVariable("id") Long idArticuloPadre){

		if(idArticuloPadre == null || idArticuloPadre <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		ArticuloPadre articuloPadre = _articuloPadreService.getArticuloPadreById(idArticuloPadre);
		if(articuloPadre == null) {

			return new ResponseEntity("Can't remove an inexistent ArticuloPadre", HttpStatus.CONFLICT);
		}

		_articuloPadreService.removeArticuloPadre(idArticuloPadre);
		return new ResponseEntity(HttpStatus.OK);



	}

}
