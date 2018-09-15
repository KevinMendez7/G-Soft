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
import com.scm.gsoft.domain.inv.MTipo;
import com.scm.gsoft.service.inv.MTipoService;

@Controller
@RequestMapping("/v1/inv")
public class MTipoController {

	@Autowired
	private MTipoService _mTipoService;

	//GET
	@RequestMapping(value = "/MTipo/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<MTipo> getMTipoById(@PathVariable("id") Long idMTipo){

		if(idMTipo == null || idMTipo <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		MTipo mTipo = _mTipoService.getMTipoById(idMTipo);
		if(mTipo == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<MTipo>(mTipo, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/MTipo", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<MTipo>> getMTipoByName(@RequestParam(value = "name", required = false) String name){

		List<MTipo> mTipoList = new ArrayList<>();

		if(name == null) {

			mTipoList = _mTipoService.getMTipoList();

			if(mTipoList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<MTipo>>(mTipoList, HttpStatus.OK);

			}

		} else {

			MTipo mTipo = _mTipoService.getMTipoByName(name);

			if(mTipo == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			mTipoList.add(mTipo);
			return new ResponseEntity<List<MTipo>>(mTipoList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/MTipo", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createMTipo(@RequestBody MTipo mTipo, UriComponentsBuilder uriComponentsBuilder){

		if(mTipo.getCodigo().equals(null)||mTipo.getCodigo().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_mTipoService.getMTipoByName(mTipo.getCodigo()) != null) {

			return new ResponseEntity("The MTipo already exist", HttpStatus.CONFLICT);

		}

		_mTipoService.createMTipo(mTipo);
		MTipo newMTipo = _mTipoService.getMTipoByName(mTipo.getCodigo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/MTipo/{id}")
				.buildAndExpand(newMTipo.getIdMTipo())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/MTipo/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<MTipo> updateMTipo(@PathVariable("id") Long idMTipo, @RequestBody MTipo mTipo){

		if(idMTipo == null || idMTipo <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		MTipo newMTipo = _mTipoService.getMTipoById(idMTipo);
		if(newMTipo == null) {

			return new ResponseEntity("There's no MTipo with the id", HttpStatus.CONFLICT);

		}

		newMTipo.setCodigo(mTipo.getCodigo());

		_mTipoService.updateMTipo(newMTipo);
		return new ResponseEntity<MTipo>(newMTipo, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/MTipo/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteMTipoById(@PathVariable("id") Long idMTipo){

		if(idMTipo == null || idMTipo <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		MTipo mTipo = _mTipoService.getMTipoById(idMTipo);
		if(mTipo == null) {

			return new ResponseEntity("Can't remove an inexistent MTipo", HttpStatus.CONFLICT);
		}

		_mTipoService.removeMTipo(idMTipo);
		return new ResponseEntity(HttpStatus.OK);



	}

}
