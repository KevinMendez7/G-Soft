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
import com.scm.gsoft.domain.cxc.Graf;
import com.scm.gsoft.service.cxc.GrafService;

@Controller
@RequestMapping("/v1/cxc")
public class GrafController {

	@Autowired
	private GrafService _grafService;

	//GET
	@RequestMapping(value = "/Graf/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Graf> getGrafById(@PathVariable("id") Long idGraf){

		if(idGraf == null || idGraf <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Graf graf = _grafService.getGrafById(idGraf);
		if(graf == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Graf>(graf, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Graf", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Graf>> getGrafByName(@RequestParam(value = "name", required = false) String name){

		List<Graf> grafList = new ArrayList<>();

		if(name == null) {

			grafList = _grafService.getGrafList();

			if(grafList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Graf>>(grafList, HttpStatus.OK);

			}

		} else {

			Graf graf = _grafService.getGrafByName(name);

			if(graf == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			grafList.add(graf);
			return new ResponseEntity<List<Graf>>(grafList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Graf", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createGraf(@RequestBody Graf graf, UriComponentsBuilder uriComponentsBuilder){

		if(graf.getIdGraf().equals(null)) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_grafService.getGrafById(graf.getIdGraf()) != null) {

			return new ResponseEntity("The Graf already exist", HttpStatus.CONFLICT);

		}

		_grafService.createGraf(graf);
		Graf newGraf = _grafService.getGrafById(graf.getIdGraf());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Graf/{id}")
				.buildAndExpand(newGraf.getIdGraf())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Graf/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Graf> updateGraf(@PathVariable("id") Long idGraf, @RequestBody Graf graf){

		if(idGraf == null || idGraf <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Graf newGraf = _grafService.getGrafById(idGraf);
		if(newGraf == null) {

			return new ResponseEntity("There's no Graf with the id", HttpStatus.CONFLICT);

		}

		newGraf.setOlegraph(graf.getOlegraph());

		_grafService.updateGraf(newGraf);
		return new ResponseEntity<Graf>(newGraf, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Graf/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteGrafById(@PathVariable("id") Long idGraf){

		if(idGraf == null || idGraf <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Graf graf = _grafService.getGrafById(idGraf);
		if(graf == null) {

			return new ResponseEntity("Can't remove an inexistent Graf", HttpStatus.CONFLICT);
		}

		_grafService.removeGraf(idGraf);
		return new ResponseEntity(HttpStatus.OK);



	}

}
