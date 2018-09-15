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
import com.scm.gsoft.domain.inv.RequisicionH;
import com.scm.gsoft.service.inv.RequisicionHService;

@Controller
@RequestMapping("/v1/inv")
public class RequisicionHController {

	@Autowired
	private RequisicionHService _requisicionHService;

	//GET
	@RequestMapping(value = "/RequisicionH/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<RequisicionH> getRequisicionHById(@PathVariable("id") Long idRequisicionH){

		if(idRequisicionH == null || idRequisicionH <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		RequisicionH requisicionH = _requisicionHService.getRequisicionHById(idRequisicionH);
		if(requisicionH == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<RequisicionH>(requisicionH, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/RequisicionH", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<RequisicionH>> getRequisicionHByName(@RequestParam(value = "name", required = false) String name){

		List<RequisicionH> requisicionHList = new ArrayList<>();

		if(name == null) {

			requisicionHList = _requisicionHService.getRequisicionHList();

			if(requisicionHList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<RequisicionH>>(requisicionHList, HttpStatus.OK);

			}

		} else {

			RequisicionH requisicionH = _requisicionHService.getRequisicionHByName(name);

			if(requisicionH == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			requisicionHList.add(requisicionH);
			return new ResponseEntity<List<RequisicionH>>(requisicionHList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/RequisicionH", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createRequisicionH(@RequestBody RequisicionH requisicionH, UriComponentsBuilder uriComponentsBuilder){

		if(requisicionH.getEntrega().equals(null)||requisicionH.getEntrega().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_requisicionHService.getRequisicionHByName(requisicionH.getEntrega()) != null) {

			return new ResponseEntity("The RequisicionH already exist", HttpStatus.CONFLICT);

		}

		_requisicionHService.createRequisicionH(requisicionH);
		RequisicionH newRequisicionH = _requisicionHService.getRequisicionHByName(requisicionH.getEntrega());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/RequisicionH/{id}")
				.buildAndExpand(newRequisicionH.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/RequisicionH/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<RequisicionH> updateRequisicionH(@PathVariable("id") Long idRequisicionH, @RequestBody RequisicionH requisicionH){

		if(idRequisicionH == null || idRequisicionH <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		RequisicionH newRequisicionH = _requisicionHService.getRequisicionHById(idRequisicionH);
		if(newRequisicionH == null) {

			return new ResponseEntity("There's no RequisicionH with the id", HttpStatus.CONFLICT);

		}

		newRequisicionH.setUsuario(requisicionH.getUsuario());
		newRequisicionH.setStatReg(requisicionH.getStatReg());

		_requisicionHService.updateRequisicionH(newRequisicionH);
		return new ResponseEntity<RequisicionH>(newRequisicionH, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/RequisicionH/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteRequisicionHById(@PathVariable("id") Long idRequisicionH){

		if(idRequisicionH == null || idRequisicionH <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		RequisicionH requisicionH = _requisicionHService.getRequisicionHById(idRequisicionH);
		if(requisicionH == null) {

			return new ResponseEntity("Can't remove an inexistent RequisicionH", HttpStatus.CONFLICT);
		}

		_requisicionHService.removeRequisicionH(idRequisicionH);
		return new ResponseEntity(HttpStatus.OK);



	}

}
