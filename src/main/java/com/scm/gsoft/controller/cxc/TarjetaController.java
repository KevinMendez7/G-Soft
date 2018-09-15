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
import com.scm.gsoft.domain.cxc.Tarjeta;
import com.scm.gsoft.service.cxc.TarjetaService;

@Controller
@RequestMapping("/v1/cxc")
public class TarjetaController {

	@Autowired
	private TarjetaService _tarjetaService;

	//GET
	@RequestMapping(value = "/Tarjeta/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Tarjeta> getTarjetaById(@PathVariable("id") Long idTarjeta){

		if(idTarjeta == null || idTarjeta <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Tarjeta tarjeta = _tarjetaService.getTarjetaById(idTarjeta);
		if(tarjeta == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Tarjeta>(tarjeta, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Tarjeta", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Tarjeta>> getTarjetaByName(@RequestParam(value = "name", required = false) String name){

		List<Tarjeta> tarjetaList = new ArrayList<>();

		if(name == null) {

			tarjetaList = _tarjetaService.getTarjetaList();

			if(tarjetaList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Tarjeta>>(tarjetaList, HttpStatus.OK);

			}

		} else {

			Tarjeta tarjeta = _tarjetaService.getTarjetaByName(name);

			if(tarjeta == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			tarjetaList.add(tarjeta);
			return new ResponseEntity<List<Tarjeta>>(tarjetaList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Tarjeta", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createTarjeta(@RequestBody Tarjeta tarjeta, UriComponentsBuilder uriComponentsBuilder){

		if(tarjeta.getNumero().equals(null)||tarjeta.getNumero().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_tarjetaService.getTarjetaByName(tarjeta.getNumero()) != null) {

			return new ResponseEntity("The Tarjeta already exist", HttpStatus.CONFLICT);

		}

		_tarjetaService.createTarjeta(tarjeta);
		Tarjeta newTarjeta = _tarjetaService.getTarjetaByName(tarjeta.getNumero());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Tarjeta/{id}")
				.buildAndExpand(newTarjeta.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Tarjeta/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Tarjeta> updateTarjeta(@PathVariable("id") Long idTarjeta, @RequestBody Tarjeta tarjeta){

		if(idTarjeta == null || idTarjeta <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Tarjeta newTarjeta = _tarjetaService.getTarjetaById(idTarjeta);
		if(newTarjeta == null) {

			return new ResponseEntity("There's no Tarjeta with the id", HttpStatus.CONFLICT);

		}
		
		newTarjeta.setUsuario(tarjeta.getUsuario());
		newTarjeta.setStatReg(tarjeta.getStatReg());

		_tarjetaService.updateTarjeta(newTarjeta);
		return new ResponseEntity<Tarjeta>(newTarjeta, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Tarjeta/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteTarjetaById(@PathVariable("id") Long idTarjeta){

		if(idTarjeta == null || idTarjeta <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Tarjeta tarjeta = _tarjetaService.getTarjetaById(idTarjeta);
		if(tarjeta == null) {

			return new ResponseEntity("Can't remove an inexistent Tarjeta", HttpStatus.CONFLICT);
		}

		_tarjetaService.removeTarjeta(idTarjeta);
		return new ResponseEntity(HttpStatus.OK);



	}

}
