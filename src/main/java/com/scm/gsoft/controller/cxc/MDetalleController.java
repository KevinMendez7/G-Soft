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
import com.scm.gsoft.domain.cxc.MDetalle;
import com.scm.gsoft.service.cxc.MDetalleService;

@Controller
@RequestMapping("/v1/cxc")
public class MDetalleController {

	@Autowired
	private MDetalleService _mDetalleService;

	//GET
	@RequestMapping(value = "/MDetalle/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<MDetalle> getMDetalleById(@PathVariable("id") Long idMDetalle){

		if(idMDetalle == null || idMDetalle <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		MDetalle mDetalle = _mDetalleService.getMDetalleById(idMDetalle);
		if(mDetalle == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<MDetalle>(mDetalle, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/MDetalle", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<MDetalle>> getMDetalleByName(@RequestParam(value = "name", required = false) String name){

		List<MDetalle> mDetalleList = new ArrayList<>();

		if(name == null) {

			mDetalleList = _mDetalleService.getMDetalleList();

			if(mDetalleList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<MDetalle>>(mDetalleList, HttpStatus.OK);

			}

		} else {

			MDetalle mDetalle = _mDetalleService.getMDetalleByName(name);

			if(mDetalle == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			mDetalleList.add(mDetalle);
			return new ResponseEntity<List<MDetalle>>(mDetalleList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/MDetalle", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createMDetalle(@RequestBody MDetalle mDetalle, UriComponentsBuilder uriComponentsBuilder){

		if(mDetalle.getCodArt().equals(null)||mDetalle.getCodArt().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_mDetalleService.getMDetalleByName(mDetalle.getCodArt()) != null) {

			return new ResponseEntity("The MDetalle already exist", HttpStatus.CONFLICT);

		}

		_mDetalleService.createMDetalle(mDetalle);
		MDetalle newMDetalle = _mDetalleService.getMDetalleByName(mDetalle.getCodArt());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/MDetalle/{id}")
				.buildAndExpand(newMDetalle.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/MDetalle/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<MDetalle> updateMDetalle(@PathVariable("id") Long idMDetalle, @RequestBody MDetalle mDetalle){

		if(idMDetalle == null || idMDetalle <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		MDetalle newMDetalle = _mDetalleService.getMDetalleById(idMDetalle);
		if(newMDetalle == null) {

			return new ResponseEntity("There's no MDetalle with the id", HttpStatus.CONFLICT);

		}

		newMDetalle.setBodega(mDetalle.getBodega());

		_mDetalleService.updateMDetalle(newMDetalle);
		return new ResponseEntity<MDetalle>(newMDetalle, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/MDetalle/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteMDetalleById(@PathVariable("id") Long idMDetalle){

		if(idMDetalle == null || idMDetalle <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		MDetalle mDetalle = _mDetalleService.getMDetalleById(idMDetalle);
		if(mDetalle == null) {

			return new ResponseEntity("Can't remove an inexistent MDetalle", HttpStatus.CONFLICT);
		}

		_mDetalleService.removeMDetalle(idMDetalle);
		return new ResponseEntity(HttpStatus.OK);



	}

}
