package com.scm.gsoft.controller.cxc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.scm.gsoft.domain.cxc.Bodega;
import com.scm.gsoft.service.cxc.BodegaService;

@Controller("BodegaControllerCxc")
@RequestMapping("/v1/cxc")
public class BodegaController {

	@Autowired
	@Qualifier("BodegaServiceCxc")
	private BodegaService _bodegaService;

	//GET
	@RequestMapping(value = "/Bodega/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Bodega> getBodegaById(@PathVariable("id") Long idBodega){

		if(idBodega == null || idBodega <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Bodega bodega = _bodegaService.getBodegaById(idBodega);
		if(bodega == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Bodega>(bodega, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Bodega", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Bodega>> getBodegaByCode(@RequestParam(value = "code", required = false) String name){

		List<Bodega> bodegaList = new ArrayList<>();

		if(name == null) {

			bodegaList = _bodegaService.getBodegaList();

			if(bodegaList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Bodega>>(bodegaList, HttpStatus.OK);

			}

		} else {

			Bodega bodega = _bodegaService.getBodegaByCode(name);

			if(bodega == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			bodegaList.add(bodega);
			return new ResponseEntity<List<Bodega>>(bodegaList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Bodega", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createBodega(@RequestBody Bodega bodega, UriComponentsBuilder uriComponentsBuilder){

		if(bodega.getCodigo().equals(null)||bodega.getCodigo().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_bodegaService.getBodegaByCode(bodega.getCodigo()) != null) {

			return new ResponseEntity("The Bodega already exist", HttpStatus.CONFLICT);

		}

		_bodegaService.createBodega(bodega);
		Bodega newBodega = _bodegaService.getBodegaByCode(bodega.getCodigo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Bodega/{id}")
				.buildAndExpand(newBodega.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Bodega/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Bodega> updateBodega(@PathVariable("id") Long idBodega, @RequestBody Bodega bodega){

		if(idBodega == null || idBodega <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Bodega newBodega = _bodegaService.getBodegaById(idBodega);
		if(newBodega == null) {

			return new ResponseEntity("There's no Bodega with the id", HttpStatus.CONFLICT);

		}

		newBodega.setCodigo(bodega.getCodigo());
		newBodega.setDescripcion(bodega.getDescripcion());		

		_bodegaService.updateBodega(newBodega);
		return new ResponseEntity<Bodega>(newBodega, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Bodega/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteBodegaById(@PathVariable("id") Long idBodega){

		if(idBodega == null || idBodega <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Bodega bodega = _bodegaService.getBodegaById(idBodega);
		if(bodega == null) {

			return new ResponseEntity("Can't remove an inexistent Bodega", HttpStatus.CONFLICT);
		}

		_bodegaService.removeBodega(idBodega);
		return new ResponseEntity(HttpStatus.OK);



	}

}
