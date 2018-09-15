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
import com.scm.gsoft.domain.cxc.CotizaH;
import com.scm.gsoft.service.cxc.CotizaHService;

@Controller
@RequestMapping("/v1/cxc")
public class CotizaHController {

	@Autowired
	private CotizaHService _cotizaHService;

	//GET
	@RequestMapping(value = "/CotizaH/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<CotizaH> getCotizaHById(@PathVariable("id") Long idCotizaH){

		if(idCotizaH == null || idCotizaH <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		CotizaH cotizaH = _cotizaHService.getCotizaHById(idCotizaH);
		if(cotizaH == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<CotizaH>(cotizaH, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/CotizaH", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<CotizaH>> getCotizaHByName(@RequestParam(value = "name", required = false) String name){

		List<CotizaH> cotizaHList = new ArrayList<>();

		if(name == null) {

			cotizaHList = _cotizaHService.getCotizaHList();

			if(cotizaHList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<CotizaH>>(cotizaHList, HttpStatus.OK);

			}

		} else {

			CotizaH cotizaH = _cotizaHService.getCotizaHByName(name);

			if(cotizaH == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			cotizaHList.add(cotizaH);
			return new ResponseEntity<List<CotizaH>>(cotizaHList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/CotizaH", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCotizaH(@RequestBody CotizaH cotizaH, UriComponentsBuilder uriComponentsBuilder){

		if(cotizaH.getNumeroFa().equals(null)||cotizaH.getNumeroFa().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_cotizaHService.getCotizaHByName(cotizaH.getNumeroFa()) != null) {

			return new ResponseEntity("The CotizaH already exist", HttpStatus.CONFLICT);

		}

		_cotizaHService.createCotizaH(cotizaH);
		CotizaH newCotizaH = _cotizaHService.getCotizaHByName(cotizaH.getNumeroFa());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/CotizaH/{id}")
				.buildAndExpand(newCotizaH.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/CotizaH/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<CotizaH> updateCotizaH(@PathVariable("id") Long idCotizaH, @RequestBody CotizaH cotizaH){

		if(idCotizaH == null || idCotizaH <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		CotizaH newCotizaH = _cotizaHService.getCotizaHById(idCotizaH);
		if(newCotizaH == null) {

			return new ResponseEntity("There's no CotizaH with the id", HttpStatus.CONFLICT);

		}
		
		newCotizaH.setUsuario(cotizaH.getUsuario());
		newCotizaH.setStatReg(cotizaH.getStatReg());

		_cotizaHService.updateCotizaH(newCotizaH);
		return new ResponseEntity<CotizaH>(newCotizaH, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/CotizaH/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteCotizaHById(@PathVariable("id") Long idCotizaH){

		if(idCotizaH == null || idCotizaH <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		CotizaH cotizaH = _cotizaHService.getCotizaHById(idCotizaH);
		if(cotizaH == null) {

			return new ResponseEntity("Can't remove an inexistent CotizaH", HttpStatus.CONFLICT);
		}

		_cotizaHService.removeCotizaH(idCotizaH);
		return new ResponseEntity(HttpStatus.OK);



	}

}
