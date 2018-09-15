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
import com.scm.gsoft.domain.cxc.Vendedor;
import com.scm.gsoft.service.cxc.VendedorService;

@Controller("VendedorControllerCxc")
@RequestMapping("/v1/cxc")
public class VendedorController {

	@Autowired
	@Qualifier("VendedorServiceCxc")
	private VendedorService _vendedorService;

	//GET
	@RequestMapping(value = "/Vendedor/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Vendedor> getVendedorById(@PathVariable("id") Long idVendedor){

		if(idVendedor == null || idVendedor <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Vendedor vendedor = _vendedorService.getVendedorById(idVendedor);
		if(vendedor == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Vendedor>(vendedor, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Vendedor", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Vendedor>> getVendedorByName(@RequestParam(value = "name", required = false) String name){

		List<Vendedor> vendedorList = new ArrayList<>();

		if(name == null) {

			vendedorList = _vendedorService.getVendedorList();

			if(vendedorList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Vendedor>>(vendedorList, HttpStatus.OK);

			}

		} else {

			Vendedor vendedor = _vendedorService.getVendedorByName(name);

			if(vendedor == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			vendedorList.add(vendedor);
			return new ResponseEntity<List<Vendedor>>(vendedorList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Vendedor", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createVendedor(@RequestBody Vendedor vendedor, UriComponentsBuilder uriComponentsBuilder){

		if(vendedor.getNombre().equals(null)||vendedor.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_vendedorService.getVendedorByName(vendedor.getNombre()) != null) {

			return new ResponseEntity("The Vendedor already exist", HttpStatus.CONFLICT);

		}

		_vendedorService.createVendedor(vendedor);
		Vendedor newVendedor = _vendedorService.getVendedorByName(vendedor.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Vendedor/{id}")
				.buildAndExpand(newVendedor.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Vendedor/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Vendedor> updateVendedor(@PathVariable("id") Long idVendedor, @RequestBody Vendedor vendedor){

		if(idVendedor == null || idVendedor <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Vendedor newVendedor = _vendedorService.getVendedorById(idVendedor);
		if(newVendedor == null) {

			return new ResponseEntity("There's no Vendedor with the id", HttpStatus.CONFLICT);

		}
		
		newVendedor.setNombre(vendedor.getNombre());
		newVendedor.setUsuario(vendedor.getUsuario());
		newVendedor.setStatReg(vendedor.getStatReg());

		_vendedorService.updateVendedor(newVendedor);
		return new ResponseEntity<Vendedor>(newVendedor, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Vendedor/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteVendedorById(@PathVariable("id") Long idVendedor){

		if(idVendedor == null || idVendedor <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Vendedor vendedor = _vendedorService.getVendedorById(idVendedor);
		if(vendedor == null) {

			return new ResponseEntity("Can't remove an inexistent Vendedor", HttpStatus.CONFLICT);
		}

		_vendedorService.removeVendedor(idVendedor);
		return new ResponseEntity(HttpStatus.OK);



	}

}
