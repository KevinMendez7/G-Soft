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
import com.scm.gsoft.domain.cxc.CotizaD;
import com.scm.gsoft.service.cxc.CotizaDService;

@Controller
@RequestMapping("/v1/cxc")
public class CotizaDController {

	@Autowired
	private CotizaDService _cotizaDService;

	//GET
	@RequestMapping(value = "/CotizaD/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<CotizaD> getCotizaDById(@PathVariable("id") Long idCotizaD){

		if(idCotizaD == null || idCotizaD <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		CotizaD cotizaD = _cotizaDService.getCotizaDById(idCotizaD);
		if(cotizaD == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<CotizaD>(cotizaD, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/CotizaD", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<CotizaD>> getCotizaDByName(@RequestParam(value = "name", required = false) String name){

		List<CotizaD> cotizaDList = new ArrayList<>();

		if(name == null) {

			cotizaDList = _cotizaDService.getCotizaDList();

			if(cotizaDList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<CotizaD>>(cotizaDList, HttpStatus.OK);

			}

		} else {

			CotizaD cotizaD = _cotizaDService.getCotizaDByName(name);

			if(cotizaD == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			cotizaDList.add(cotizaD);
			return new ResponseEntity<List<CotizaD>>(cotizaDList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/CotizaD", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCotizaD(@RequestBody CotizaD cotizaD, UriComponentsBuilder uriComponentsBuilder){

		if(cotizaD.getNumDcto().equals(null)||cotizaD.getNumDcto().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_cotizaDService.getCotizaDByName(cotizaD.getNumDcto()) != null) {

			return new ResponseEntity("The CotizaD already exist", HttpStatus.CONFLICT);

		}

		_cotizaDService.createCotizaD(cotizaD);
		CotizaD newCotizaD = _cotizaDService.getCotizaDByName(cotizaD.getNumDcto());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/CotizaD/{id}")
				.buildAndExpand(newCotizaD.getIdCotizaD())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/CotizaD/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<CotizaD> updateCotizaD(@PathVariable("id") Long idCotizaD, @RequestBody CotizaD cotizaD){

		if(idCotizaD == null || idCotizaD <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		CotizaD newCotizaD = _cotizaDService.getCotizaDById(idCotizaD);
		if(newCotizaD == null) {

			return new ResponseEntity("There's no CotizaD with the id", HttpStatus.CONFLICT);

		}
	
		newCotizaD.setUsuario(cotizaD.getUsuario());
		newCotizaD.setStatReg(cotizaD.getStatReg());

		_cotizaDService.updateCotizaD(newCotizaD);
		return new ResponseEntity<CotizaD>(newCotizaD, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/CotizaD/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteCotizaDById(@PathVariable("id") Long idCotizaD){

		if(idCotizaD == null || idCotizaD <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		CotizaD cotizaD = _cotizaDService.getCotizaDById(idCotizaD);
		if(cotizaD == null) {

			return new ResponseEntity("Can't remove an inexistent CotizaD", HttpStatus.CONFLICT);
		}

		_cotizaDService.removeCotizaD(idCotizaD);
		return new ResponseEntity(HttpStatus.OK);



	}

}
