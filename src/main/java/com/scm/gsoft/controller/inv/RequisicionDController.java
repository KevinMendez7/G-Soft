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
import com.scm.gsoft.domain.inv.RequisicionD;
import com.scm.gsoft.service.inv.RequisicionDService;

@Controller
@RequestMapping("/v1/inv")
public class RequisicionDController {

	@Autowired
	private RequisicionDService _requisicionDService;

	//GET
	@RequestMapping(value = "/RequisicionD/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<RequisicionD> getRequisicionDById(@PathVariable("id") Long idRequisicionD){

		if(idRequisicionD == null || idRequisicionD <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		RequisicionD requisicionD = _requisicionDService.getRequisicionDById(idRequisicionD);
		if(requisicionD == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<RequisicionD>(requisicionD, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/RequisicionD", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<RequisicionD>> getRequisicionDByName(@RequestParam(value = "name", required = false) String name){

		List<RequisicionD> requisicionDList = new ArrayList<>();

		if(name == null) {

			requisicionDList = _requisicionDService.getRequisicionDList();

			if(requisicionDList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<RequisicionD>>(requisicionDList, HttpStatus.OK);

			}

		} else {

			RequisicionD requisicionD = _requisicionDService.getRequisicionDByName(name);

			if(requisicionD == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			requisicionDList.add(requisicionD);
			return new ResponseEntity<List<RequisicionD>>(requisicionDList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/RequisicionD", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createRequisicionD(@RequestBody RequisicionD requisicionD, UriComponentsBuilder uriComponentsBuilder){

		if(requisicionD.getDocum().equals(null)||requisicionD.getDocum().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_requisicionDService.getRequisicionDByName(requisicionD.getDocum()) != null) {

			return new ResponseEntity("The RequisicionD already exist", HttpStatus.CONFLICT);

		}

		_requisicionDService.createRequisicionD(requisicionD);
		RequisicionD newRequisicionD = _requisicionDService.getRequisicionDByName(requisicionD.getDocum());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/RequisicionD/{id}")
				.buildAndExpand(newRequisicionD.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/RequisicionD/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<RequisicionD> updateRequisicionD(@PathVariable("id") Long idRequisicionD, @RequestBody RequisicionD requisicionD){

		if(idRequisicionD == null || idRequisicionD <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		RequisicionD newRequisicionD = _requisicionDService.getRequisicionDById(idRequisicionD);
		if(newRequisicionD == null) {

			return new ResponseEntity("There's no RequisicionD with the id", HttpStatus.CONFLICT);

		}

		newRequisicionD.setUsuario(requisicionD.getUsuario());
		newRequisicionD.setStatReg(requisicionD.getStatReg());

		_requisicionDService.updateRequisicionD(newRequisicionD);
		return new ResponseEntity<RequisicionD>(newRequisicionD, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/RequisicionD/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteRequisicionDById(@PathVariable("id") Long idRequisicionD){

		if(idRequisicionD == null || idRequisicionD <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		RequisicionD requisicionD = _requisicionDService.getRequisicionDById(idRequisicionD);
		if(requisicionD == null) {

			return new ResponseEntity("Can't remove an inexistent RequisicionD", HttpStatus.CONFLICT);
		}

		_requisicionDService.removeRequisicionD(idRequisicionD);
		return new ResponseEntity(HttpStatus.OK);



	}

}
