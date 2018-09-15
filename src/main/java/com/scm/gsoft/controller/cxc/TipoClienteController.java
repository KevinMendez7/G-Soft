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
import com.scm.gsoft.domain.cxc.TipoCliente;
import com.scm.gsoft.service.cxc.TipoClienteService;

@Controller
@RequestMapping("/v1/cxc")
public class TipoClienteController {

	@Autowired
	private TipoClienteService _tipoClienteService;

	//GET
	@RequestMapping(value = "/TipoCliente/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<TipoCliente> getTipoClienteById(@PathVariable("id") Long idTipoCliente){

		if(idTipoCliente == null || idTipoCliente <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		TipoCliente tipoCliente = _tipoClienteService.getTipoClienteById(idTipoCliente);
		if(tipoCliente == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<TipoCliente>(tipoCliente, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/TipoCliente", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<TipoCliente>> getTipoClienteByName(@RequestParam(value = "name", required = false) String name){

		List<TipoCliente> tipoClienteList = new ArrayList<>();

		if(name == null) {

			tipoClienteList = _tipoClienteService.getTipoClienteList();

			if(tipoClienteList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<TipoCliente>>(tipoClienteList, HttpStatus.OK);

			}

		} else {

			TipoCliente tipoCliente = _tipoClienteService.getTipoClienteByName(name);

			if(tipoCliente == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			tipoClienteList.add(tipoCliente);
			return new ResponseEntity<List<TipoCliente>>(tipoClienteList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/TipoCliente", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createTipoCliente(@RequestBody TipoCliente tipoCliente, UriComponentsBuilder uriComponentsBuilder){

		if(tipoCliente.getCodCli().equals(null)||tipoCliente.getCodCli().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_tipoClienteService.getTipoClienteByName(tipoCliente.getCodCli()) != null) {

			return new ResponseEntity("The TipoCliente already exist", HttpStatus.CONFLICT);

		}

		_tipoClienteService.createTipoCliente(tipoCliente);
		TipoCliente newTipoCliente = _tipoClienteService.getTipoClienteByName(tipoCliente.getCodCli());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/TipoCliente/{id}")
				.buildAndExpand(newTipoCliente.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/TipoCliente/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<TipoCliente> updateTipoCliente(@PathVariable("id") Long idTipoCliente, @RequestBody TipoCliente tipoCliente){

		if(idTipoCliente == null || idTipoCliente <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		TipoCliente newTipoCliente = _tipoClienteService.getTipoClienteById(idTipoCliente);
		if(newTipoCliente == null) {

			return new ResponseEntity("There's no TipoCliente with the id", HttpStatus.CONFLICT);

		}
		
		newTipoCliente.setUsuario(tipoCliente.getUsuario());
		newTipoCliente.setStatReg(tipoCliente.getStatReg());

		_tipoClienteService.updateTipoCliente(newTipoCliente);
		return new ResponseEntity<TipoCliente>(newTipoCliente, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/TipoCliente/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteTipoClienteById(@PathVariable("id") Long idTipoCliente){

		if(idTipoCliente == null || idTipoCliente <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		TipoCliente tipoCliente = _tipoClienteService.getTipoClienteById(idTipoCliente);
		if(tipoCliente == null) {

			return new ResponseEntity("Can't remove an inexistent TipoCliente", HttpStatus.CONFLICT);
		}

		_tipoClienteService.removeTipoCliente(idTipoCliente);
		return new ResponseEntity(HttpStatus.OK);



	}

}
