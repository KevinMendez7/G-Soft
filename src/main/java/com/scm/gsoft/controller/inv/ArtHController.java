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
import com.scm.gsoft.domain.inv.ArtH;
import com.scm.gsoft.service.inv.ArtHService;

@Controller
@RequestMapping("/v1/inv")
public class ArtHController {

	@Autowired
	private ArtHService _artHService;

	//GET
	@RequestMapping(value = "/ArtH/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<ArtH> getArtHById(@PathVariable("id") Long idArtH){

		if(idArtH == null || idArtH <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		ArtH artH = _artHService.getArtHById(idArtH);
		if(artH == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<ArtH>(artH, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/ArtH", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<ArtH>> getArtHByName(@RequestParam(value = "name", required = false) String name){

		List<ArtH> artHList = new ArrayList<>();

		if(name == null) {

			artHList = _artHService.getArtHList();

			if(artHList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<ArtH>>(artHList, HttpStatus.OK);

			}

		} else {

			ArtH artH = _artHService.getArtHByName(name);

			if(artH == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			artHList.add(artH);
			return new ResponseEntity<List<ArtH>>(artHList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/ArtH", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createArtH(@RequestBody ArtH artH, UriComponentsBuilder uriComponentsBuilder){

		if(artH.getBodega().equals(null)||artH.getBodega().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_artHService.getArtHByName(artH.getBodega()) != null) {

			return new ResponseEntity("The ArtH already exist", HttpStatus.CONFLICT);

		}

		_artHService.createArtH(artH);
		ArtH newArtH = _artHService.getArtHByName(artH.getBodega());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/ArtH/{id}")
				.buildAndExpand(newArtH.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/ArtH/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<ArtH> updateArtH(@PathVariable("id") Long idArtH, @RequestBody ArtH artH){

		if(idArtH == null || idArtH <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		ArtH newArtH = _artHService.getArtHById(idArtH);
		if(newArtH == null) {

			return new ResponseEntity("There's no ArtH with the id", HttpStatus.CONFLICT);

		}
		
		newArtH.setBodega(artH.getBodega());
		newArtH.setUsuario(artH.getUsuario());
		newArtH.setStatReg(artH.getStatReg());

		_artHService.updateArtH(newArtH);
		return new ResponseEntity<ArtH>(newArtH, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/ArtH/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteArtHById(@PathVariable("id") Long idArtH){

		if(idArtH == null || idArtH <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		ArtH artH = _artHService.getArtHById(idArtH);
		if(artH == null) {

			return new ResponseEntity("Can't remove an inexistent ArtH", HttpStatus.CONFLICT);
		}

		_artHService.removeArtH(idArtH);
		return new ResponseEntity(HttpStatus.OK);



	}

}
