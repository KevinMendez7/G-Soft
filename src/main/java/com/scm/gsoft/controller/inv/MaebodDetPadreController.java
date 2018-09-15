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
import com.scm.gsoft.domain.inv.MaebodDetPadre;
import com.scm.gsoft.service.inv.MaebodDetPadreService;

@Controller
@RequestMapping("/v1/inv")
public class MaebodDetPadreController {

	@Autowired
	private MaebodDetPadreService _maebodDetPadreService;

	//GET
	@RequestMapping(value = "/MaebodDetPadre/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<MaebodDetPadre> getMaebodDetPadreById(@PathVariable("id") Long idMaebodDetPadre){

		if(idMaebodDetPadre == null || idMaebodDetPadre <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		MaebodDetPadre maebodDetPadre = _maebodDetPadreService.getMaebodDetPadreById(idMaebodDetPadre);
		if(maebodDetPadre == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<MaebodDetPadre>(maebodDetPadre, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/MaebodDetPadre", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<MaebodDetPadre>> getMaebodDetPadreByName(@RequestParam(value = "name", required = false) String name){

		List<MaebodDetPadre> maebodDetPadreList = new ArrayList<>();

		if(name == null) {

			maebodDetPadreList = _maebodDetPadreService.getMaebodDetPadreList();

			if(maebodDetPadreList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<MaebodDetPadre>>(maebodDetPadreList, HttpStatus.OK);

			}

		} else {

			MaebodDetPadre maebodDetPadre = _maebodDetPadreService.getMaebodDetPadreByName(name);

			if(maebodDetPadre == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			maebodDetPadreList.add(maebodDetPadre);
			return new ResponseEntity<List<MaebodDetPadre>>(maebodDetPadreList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/MaebodDetPadre", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createMaebodDetPadre(@RequestBody MaebodDetPadre maebodDetPadre, UriComponentsBuilder uriComponentsBuilder){

		if(maebodDetPadre.getAnio().equals(null)||maebodDetPadre.getAnio().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_maebodDetPadreService.getMaebodDetPadreByName(maebodDetPadre.getAnio()) != null) {

			return new ResponseEntity("The MaebodDetPadre already exist", HttpStatus.CONFLICT);

		}

		_maebodDetPadreService.createMaebodDetPadre(maebodDetPadre);
		MaebodDetPadre newMaebodDetPadre = _maebodDetPadreService.getMaebodDetPadreByName(maebodDetPadre.getAnio());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/MaebodDetPadre/{id}")
				.buildAndExpand(newMaebodDetPadre.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/MaebodDetPadre/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<MaebodDetPadre> updateMaebodDetPadre(@PathVariable("id") Long idMaebodDetPadre, @RequestBody MaebodDetPadre maebodDetPadre){

		if(idMaebodDetPadre == null || idMaebodDetPadre <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		MaebodDetPadre newMaebodDetPadre = _maebodDetPadreService.getMaebodDetPadreById(idMaebodDetPadre);
		if(newMaebodDetPadre == null) {

			return new ResponseEntity("There's no MaebodDetPadre with the id", HttpStatus.CONFLICT);

		}

		newMaebodDetPadre.setUsuario(maebodDetPadre.getUsuario());
		newMaebodDetPadre.setStatReg(maebodDetPadre.getStatReg());

		_maebodDetPadreService.updateMaebodDetPadre(newMaebodDetPadre);
		return new ResponseEntity<MaebodDetPadre>(newMaebodDetPadre, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/MaebodDetPadre/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteMaebodDetPadreById(@PathVariable("id") Long idMaebodDetPadre){

		if(idMaebodDetPadre == null || idMaebodDetPadre <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		MaebodDetPadre maebodDetPadre = _maebodDetPadreService.getMaebodDetPadreById(idMaebodDetPadre);
		if(maebodDetPadre == null) {

			return new ResponseEntity("Can't remove an inexistent MaebodDetPadre", HttpStatus.CONFLICT);
		}

		_maebodDetPadreService.removeMaebodDetPadre(idMaebodDetPadre);
		return new ResponseEntity(HttpStatus.OK);



	}

}
