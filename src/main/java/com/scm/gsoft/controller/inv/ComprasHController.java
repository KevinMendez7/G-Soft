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
import com.scm.gsoft.domain.inv.ComprasH;
import com.scm.gsoft.service.inv.ComprasHService;

@Controller
@RequestMapping("/v1/inv")
public class ComprasHController {

	@Autowired
	private ComprasHService _comprasHService;

	//GET
	@RequestMapping(value = "/ComprasH/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<ComprasH> getComprasHById(@PathVariable("id") Long idComprasH){

		if(idComprasH == null || idComprasH <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		ComprasH comprasH = _comprasHService.getComprasHById(idComprasH);
		if(comprasH == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<ComprasH>(comprasH, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/ComprasH", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<ComprasH>> getComprasHByName(@RequestParam(value = "name", required = false) String name){

		List<ComprasH> comprasHList = new ArrayList<>();

		if(name == null) {

			comprasHList = _comprasHService.getComprasHList();

			if(comprasHList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<ComprasH>>(comprasHList, HttpStatus.OK);

			}

		} else {

			ComprasH comprasH = _comprasHService.getComprasHByName(name);

			if(comprasH == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			comprasHList.add(comprasH);
			return new ResponseEntity<List<ComprasH>>(comprasHList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/ComprasH", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createComprasH(@RequestBody ComprasH comprasH, UriComponentsBuilder uriComponentsBuilder){

		if(comprasH.getBodega().equals(null)||comprasH.getBodega().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_comprasHService.getComprasHByName(comprasH.getBodega()) != null) {

			return new ResponseEntity("The ComprasH already exist", HttpStatus.CONFLICT);

		}

		_comprasHService.createComprasH(comprasH);
		ComprasH newComprasH = _comprasHService.getComprasHByName(comprasH.getBodega());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/ComprasH/{id}")
				.buildAndExpand(newComprasH.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/ComprasH/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<ComprasH> updateComprasH(@PathVariable("id") Long idComprasH, @RequestBody ComprasH comprasH){

		if(idComprasH == null || idComprasH <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		ComprasH newComprasH = _comprasHService.getComprasHById(idComprasH);
		if(newComprasH == null) {

			return new ResponseEntity("There's no ComprasH with the id", HttpStatus.CONFLICT);

		}

		newComprasH.setUsuario(comprasH.getUsuario());
		newComprasH.setStatReg(comprasH.getStatReg());

		_comprasHService.updateComprasH(newComprasH);
		return new ResponseEntity<ComprasH>(newComprasH, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/ComprasH/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteComprasHById(@PathVariable("id") Long idComprasH){

		if(idComprasH == null || idComprasH <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		ComprasH comprasH = _comprasHService.getComprasHById(idComprasH);
		if(comprasH == null) {

			return new ResponseEntity("Can't remove an inexistent ComprasH", HttpStatus.CONFLICT);
		}

		_comprasHService.removeComprasH(idComprasH);
		return new ResponseEntity(HttpStatus.OK);



	}

}
