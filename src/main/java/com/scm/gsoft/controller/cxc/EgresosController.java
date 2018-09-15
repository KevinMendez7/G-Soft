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
import com.scm.gsoft.domain.cxc.Egresos;
import com.scm.gsoft.service.cxc.EgresosService;

@Controller
@RequestMapping("/v1/cxc")
public class EgresosController {

	@Autowired
	private EgresosService _egresosService;

	//GET
	@RequestMapping(value = "/Egresos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Egresos> getEgresosById(@PathVariable("id") Long idEgresos){

		if(idEgresos == null || idEgresos <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Egresos egresos = _egresosService.getEgresosById(idEgresos);
		if(egresos == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Egresos>(egresos, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Egresos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Egresos>> getEgresosByName(@RequestParam(value = "name", required = false) String name){

		List<Egresos> egresosList = new ArrayList<>();

		if(name == null) {

			egresosList = _egresosService.getEgresosList();

			if(egresosList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Egresos>>(egresosList, HttpStatus.OK);

			}

		} else {

			Egresos egresos = _egresosService.getEgresosByName(name);

			if(egresos == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			egresosList.add(egresos);
			return new ResponseEntity<List<Egresos>>(egresosList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Egresos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createEgresos(@RequestBody Egresos egresos, UriComponentsBuilder uriComponentsBuilder){

		if(egresos.getCodEgresos().equals(null)||egresos.getCodEgresos().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_egresosService.getEgresosByName(egresos.getCodEgresos()) != null) {

			return new ResponseEntity("The Egresos already exist", HttpStatus.CONFLICT);

		}

		_egresosService.createEgresos(egresos);
		Egresos newEgresos = _egresosService.getEgresosByName(egresos.getCodEgresos());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Egresos/{id}")
				.buildAndExpand(newEgresos.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Egresos/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Egresos> updateEgresos(@PathVariable("id") Long idEgresos, @RequestBody Egresos egresos){

		if(idEgresos == null || idEgresos <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Egresos newEgresos = _egresosService.getEgresosById(idEgresos);
		if(newEgresos == null) {

			return new ResponseEntity("There's no Egresos with the id", HttpStatus.CONFLICT);

		}

		newEgresos.setUsuario(egresos.getUsuario());
		newEgresos.setStatReg(egresos.getStatReg());

		_egresosService.updateEgresos(newEgresos);
		return new ResponseEntity<Egresos>(newEgresos, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Egresos/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteEgresosById(@PathVariable("id") Long idEgresos){

		if(idEgresos == null || idEgresos <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Egresos egresos = _egresosService.getEgresosById(idEgresos);
		if(egresos == null) {

			return new ResponseEntity("Can't remove an inexistent Egresos", HttpStatus.CONFLICT);
		}

		_egresosService.removeEgresos(idEgresos);
		return new ResponseEntity(HttpStatus.OK);



	}

}
