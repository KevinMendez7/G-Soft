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
import com.scm.gsoft.domain.inv.HistArtD;
import com.scm.gsoft.service.inv.HistArtDService;

@Controller
@RequestMapping("/v1/inv")
public class HistArtDController {

	@Autowired
	private HistArtDService _histArtDService;

	//GET
	@RequestMapping(value = "/HistArtD/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<HistArtD> getHistArtDById(@PathVariable("id") Long idHistArtD){

		if(idHistArtD == null || idHistArtD <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		HistArtD histArtD = _histArtDService.getHistArtDById(idHistArtD);
		if(histArtD == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<HistArtD>(histArtD, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/HistArtD", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<HistArtD>> getHistArtDByName(@RequestParam(value = "name", required = false) String name){

		List<HistArtD> histArtDList = new ArrayList<>();

		if(name == null) {

			histArtDList = _histArtDService.getHistArtDList();

			if(histArtDList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<HistArtD>>(histArtDList, HttpStatus.OK);

			}

		} else {

			HistArtD histArtD = _histArtDService.getHistArtDByName(name);

			if(histArtD == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			histArtDList.add(histArtD);
			return new ResponseEntity<List<HistArtD>>(histArtDList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/HistArtD", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createHistArtD(@RequestBody HistArtD histArtD, UriComponentsBuilder uriComponentsBuilder){

		if(histArtD.getNombre().equals(null)||histArtD.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_histArtDService.getHistArtDByName(histArtD.getNombre()) != null) {

			return new ResponseEntity("The HistArtD already exist", HttpStatus.CONFLICT);

		}

		_histArtDService.createHistArtD(histArtD);
		HistArtD newHistArtD = _histArtDService.getHistArtDByName(histArtD.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/HistArtD/{id}")
				.buildAndExpand(newHistArtD.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/HistArtD/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<HistArtD> updateHistArtD(@PathVariable("id") Long idHistArtD, @RequestBody HistArtD histArtD){

		if(idHistArtD == null || idHistArtD <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		HistArtD newHistArtD = _histArtDService.getHistArtDById(idHistArtD);
		if(newHistArtD == null) {

			return new ResponseEntity("There's no HistArtD with the id", HttpStatus.CONFLICT);

		}

		newHistArtD.setNombre(histArtD.getNombre());
		newHistArtD.setUsuario(histArtD.getUsuario());
		newHistArtD.setStatReg(histArtD.getStatReg());

		_histArtDService.updateHistArtD(newHistArtD);
		return new ResponseEntity<HistArtD>(newHistArtD, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/HistArtD/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteHistArtDById(@PathVariable("id") Long idHistArtD){

		if(idHistArtD == null || idHistArtD <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		HistArtD histArtD = _histArtDService.getHistArtDById(idHistArtD);
		if(histArtD == null) {

			return new ResponseEntity("Can't remove an inexistent HistArtD", HttpStatus.CONFLICT);
		}

		_histArtDService.removeHistArtD(idHistArtD);
		return new ResponseEntity(HttpStatus.OK);



	}

}
