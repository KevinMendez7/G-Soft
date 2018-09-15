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
import com.scm.gsoft.domain.inv.HistArtH;
import com.scm.gsoft.service.inv.HistArtHService;

@Controller
@RequestMapping("/v1/inv")
public class HistArtHController {

	@Autowired
	private HistArtHService _histArtHService;

	//GET
	@RequestMapping(value = "/HistArtH/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<HistArtH> getHistArtHById(@PathVariable("id") Long idHistArtH){

		if(idHistArtH == null || idHistArtH <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		HistArtH histArtH = _histArtHService.getHistArtHById(idHistArtH);
		if(histArtH == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<HistArtH>(histArtH, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/HistArtH", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<HistArtH>> getHistArtHByName(@RequestParam(value = "name", required = false) String name){

		List<HistArtH> histArtHList = new ArrayList<>();

		if(name == null) {

			histArtHList = _histArtHService.getHistArtHList();

			if(histArtHList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<HistArtH>>(histArtHList, HttpStatus.OK);

			}

		} else {

			HistArtH histArtH = _histArtHService.getHistArtHByName(name);

			if(histArtH == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			histArtHList.add(histArtH);
			return new ResponseEntity<List<HistArtH>>(histArtHList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/HistArtH", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createHistArtH(@RequestBody HistArtH histArtH, UriComponentsBuilder uriComponentsBuilder){

		if(histArtH.getBodega().equals(null)||histArtH.getBodega().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_histArtHService.getHistArtHByName(histArtH.getBodega()) != null) {

			return new ResponseEntity("The HistArtH already exist", HttpStatus.CONFLICT);

		}

		_histArtHService.createHistArtH(histArtH);
		HistArtH newHistArtH = _histArtHService.getHistArtHByName(histArtH.getBodega());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/HistArtH/{id}")
				.buildAndExpand(newHistArtH.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/HistArtH/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<HistArtH> updateHistArtH(@PathVariable("id") Long idHistArtH, @RequestBody HistArtH histArtH){

		if(idHistArtH == null || idHistArtH <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		HistArtH newHistArtH = _histArtHService.getHistArtHById(idHistArtH);
		if(newHistArtH == null) {

			return new ResponseEntity("There's no HistArtH with the id", HttpStatus.CONFLICT);

		}

		newHistArtH.setUsuario(histArtH.getUsuario());
		newHistArtH.setStatReg(histArtH.getStatReg());

		_histArtHService.updateHistArtH(newHistArtH);
		return new ResponseEntity<HistArtH>(newHistArtH, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/HistArtH/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteHistArtHById(@PathVariable("id") Long idHistArtH){

		if(idHistArtH == null || idHistArtH <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		HistArtH histArtH = _histArtHService.getHistArtHById(idHistArtH);
		if(histArtH == null) {

			return new ResponseEntity("Can't remove an inexistent HistArtH", HttpStatus.CONFLICT);
		}

		_histArtHService.removeHistArtH(idHistArtH);
		return new ResponseEntity(HttpStatus.OK);



	}

}
