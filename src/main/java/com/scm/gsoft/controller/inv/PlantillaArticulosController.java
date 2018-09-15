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
import com.scm.gsoft.domain.inv.PlantillaArticulos;
import com.scm.gsoft.service.inv.PlantillaArticulosService;

@Controller
@RequestMapping("/v1/inv")
public class PlantillaArticulosController {

	@Autowired
	private PlantillaArticulosService _plantillaArticulosService;

	//GET
	@RequestMapping(value = "/PlantillaArticulos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<PlantillaArticulos> getPlantillaArticulosById(@PathVariable("id") Long idPlantillaArticulos){

		if(idPlantillaArticulos == null || idPlantillaArticulos <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		PlantillaArticulos plantillaArticulos = _plantillaArticulosService.getPlantillaArticulosById(idPlantillaArticulos);
		if(plantillaArticulos == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<PlantillaArticulos>(plantillaArticulos, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/PlantillaArticulos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<PlantillaArticulos>> getPlantillaArticulosByName(@RequestParam(value = "name", required = false) String name){

		List<PlantillaArticulos> plantillaArticulosList = new ArrayList<>();

		if(name == null) {

			plantillaArticulosList = _plantillaArticulosService.getPlantillaArticulosList();

			if(plantillaArticulosList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<PlantillaArticulos>>(plantillaArticulosList, HttpStatus.OK);

			}

		} else {

			PlantillaArticulos plantillaArticulos = _plantillaArticulosService.getPlantillaArticulosByName(name);

			if(plantillaArticulos == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			plantillaArticulosList.add(plantillaArticulos);
			return new ResponseEntity<List<PlantillaArticulos>>(plantillaArticulosList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/PlantillaArticulos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createPlantillaArticulos(@RequestBody PlantillaArticulos plantillaArticulos, UriComponentsBuilder uriComponentsBuilder){

		if(plantillaArticulos.getNombre().equals(null)||plantillaArticulos.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_plantillaArticulosService.getPlantillaArticulosByName(plantillaArticulos.getNombre()) != null) {

			return new ResponseEntity("The PlantillaArticulos already exist", HttpStatus.CONFLICT);

		}

		_plantillaArticulosService.createPlantillaArticulos(plantillaArticulos);
		PlantillaArticulos newPlantillaArticulos = _plantillaArticulosService.getPlantillaArticulosByName(plantillaArticulos.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/PlantillaArticulos/{id}")
				.buildAndExpand(newPlantillaArticulos.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/PlantillaArticulos/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<PlantillaArticulos> updatePlantillaArticulos(@PathVariable("id") Long idPlantillaArticulos, @RequestBody PlantillaArticulos plantillaArticulos){

		if(idPlantillaArticulos == null || idPlantillaArticulos <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		PlantillaArticulos newPlantillaArticulos = _plantillaArticulosService.getPlantillaArticulosById(idPlantillaArticulos);
		if(newPlantillaArticulos == null) {

			return new ResponseEntity("There's no PlantillaArticulos with the id", HttpStatus.CONFLICT);

		}
		
		newPlantillaArticulos.setNombre(plantillaArticulos.getNombre());
		newPlantillaArticulos.setUsuario(plantillaArticulos.getUsuario());
		newPlantillaArticulos.setStatReg(plantillaArticulos.getStatReg());

		_plantillaArticulosService.updatePlantillaArticulos(newPlantillaArticulos);
		return new ResponseEntity<PlantillaArticulos>(newPlantillaArticulos, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/PlantillaArticulos/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deletePlantillaArticulosById(@PathVariable("id") Long idPlantillaArticulos){

		if(idPlantillaArticulos == null || idPlantillaArticulos <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		PlantillaArticulos plantillaArticulos = _plantillaArticulosService.getPlantillaArticulosById(idPlantillaArticulos);
		if(plantillaArticulos == null) {

			return new ResponseEntity("Can't remove an inexistent PlantillaArticulos", HttpStatus.CONFLICT);
		}

		_plantillaArticulosService.removePlantillaArticulos(idPlantillaArticulos);
		return new ResponseEntity(HttpStatus.OK);



	}

}
