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
import com.scm.gsoft.domain.inv.ComprasD;
import com.scm.gsoft.service.inv.ComprasDService;

@Controller
@RequestMapping("/v1/inv")
public class ComprasDController {

	@Autowired
	private ComprasDService _comprasDService;

	//GET
	@RequestMapping(value = "/ComprasD/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<ComprasD> getComprasDById(@PathVariable("id") Long idComprasD){

		if(idComprasD == null || idComprasD <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		ComprasD comprasD = _comprasDService.getComprasDById(idComprasD);
		if(comprasD == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<ComprasD>(comprasD, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/ComprasD", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<ComprasD>> getComprasDByName(@RequestParam(value = "name", required = false) String name){

		List<ComprasD> comprasDList = new ArrayList<>();

		if(name == null) {

			comprasDList = _comprasDService.getComprasDList();

			if(comprasDList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<ComprasD>>(comprasDList, HttpStatus.OK);

			}

		} else {

			ComprasD comprasD = _comprasDService.getComprasDByName(name);

			if(comprasD == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			comprasDList.add(comprasD);
			return new ResponseEntity<List<ComprasD>>(comprasDList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/ComprasD", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createComprasD(@RequestBody ComprasD comprasD, UriComponentsBuilder uriComponentsBuilder){

		if(comprasD.getNombre().equals(null)||comprasD.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_comprasDService.getComprasDByName(comprasD.getNombre()) != null) {

			return new ResponseEntity("The ComprasD already exist", HttpStatus.CONFLICT);

		}

		_comprasDService.createComprasD(comprasD);
		ComprasD newComprasD = _comprasDService.getComprasDByName(comprasD.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/ComprasD/{id}")
				.buildAndExpand(newComprasD.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/ComprasD/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<ComprasD> updateComprasD(@PathVariable("id") Long idComprasD, @RequestBody ComprasD comprasD){

		if(idComprasD == null || idComprasD <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		ComprasD newComprasD = _comprasDService.getComprasDById(idComprasD);
		if(newComprasD == null) {

			return new ResponseEntity("There's no ComprasD with the id", HttpStatus.CONFLICT);

		}

		newComprasD.setNombre(comprasD.getNombre());
		newComprasD.setUsuario(comprasD.getUsuario());
		newComprasD.setStatReg(comprasD.getStatReg());

		_comprasDService.updateComprasD(newComprasD);
		return new ResponseEntity<ComprasD>(newComprasD, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/ComprasD/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteComprasDById(@PathVariable("id") Long idComprasD){

		if(idComprasD == null || idComprasD <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		ComprasD comprasD = _comprasDService.getComprasDById(idComprasD);
		if(comprasD == null) {

			return new ResponseEntity("Can't remove an inexistent ComprasD", HttpStatus.CONFLICT);
		}

		_comprasDService.removeComprasD(idComprasD);
		return new ResponseEntity(HttpStatus.OK);



	}

}
