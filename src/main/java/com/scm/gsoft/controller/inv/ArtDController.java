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
import com.scm.gsoft.domain.inv.ArtD;
import com.scm.gsoft.service.inv.ArtDService;

@Controller
@RequestMapping("/v1/inv")
public class ArtDController {

	@Autowired
	private ArtDService _artDService;

	//GET
	@RequestMapping(value = "/ArtD/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<ArtD> getArtDById(@PathVariable("id") Long idArtD){

		if(idArtD == null || idArtD <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		ArtD artD = _artDService.getArtDById(idArtD);
		if(artD == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<ArtD>(artD, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/ArtD", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<ArtD>> getArtDByName(@RequestParam(value = "name", required = false) String name){

		List<ArtD> artDList = new ArrayList<>();

		if(name == null) {

			artDList = _artDService.getArtDList();

			if(artDList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<ArtD>>(artDList, HttpStatus.OK);

			}

		} else {

			ArtD artD = _artDService.getArtDByName(name);

			if(artD == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			artDList.add(artD);
			return new ResponseEntity<List<ArtD>>(artDList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/ArtD", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createArtD(@RequestBody ArtD artD, UriComponentsBuilder uriComponentsBuilder){

		if(artD.getNombre().equals(null)||artD.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_artDService.getArtDByName(artD.getNombre()) != null) {

			return new ResponseEntity("The ArtD already exist", HttpStatus.CONFLICT);

		}

		_artDService.createArtD(artD);
		ArtD newArtD = _artDService.getArtDByName(artD.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/ArtD/{id}")
				.buildAndExpand(newArtD.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/ArtD/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<ArtD> updateArtD(@PathVariable("id") Long idArtD, @RequestBody ArtD artD){

		if(idArtD == null || idArtD <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		ArtD newArtD = _artDService.getArtDById(idArtD);
		if(newArtD == null) {

			return new ResponseEntity("There's no ArtD with the id", HttpStatus.CONFLICT);

		}
		
		newArtD.setNombre(artD.getNombre());
		newArtD.setUsuario(artD.getUsuario());
		newArtD.setStatReg(artD.getStatReg());

		_artDService.updateArtD(newArtD);
		return new ResponseEntity<ArtD>(newArtD, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/ArtD/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteArtDById(@PathVariable("id") Long idArtD){

		if(idArtD == null || idArtD <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		ArtD artD = _artDService.getArtDById(idArtD);
		if(artD == null) {

			return new ResponseEntity("Can't remove an inexistent ArtD", HttpStatus.CONFLICT);
		}

		_artDService.removeArtD(idArtD);
		return new ResponseEntity(HttpStatus.OK);



	}

}
