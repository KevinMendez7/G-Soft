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
import com.scm.gsoft.domain.cxc.UsuarioVendedor;
import com.scm.gsoft.service.cxc.UsuarioVendedorService;

@Controller
@RequestMapping("/v1/cxc")
public class UsuarioVendedorController {

	@Autowired
	private UsuarioVendedorService _usuarioVendedorService;

	//GET
	@RequestMapping(value = "/UsuarioVendedor/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<UsuarioVendedor> getUsuarioVendedorById(@PathVariable("id") Long idUsuarioVendedor){

		if(idUsuarioVendedor == null || idUsuarioVendedor <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		UsuarioVendedor usuarioVendedor = _usuarioVendedorService.getUsuarioVendedorById(idUsuarioVendedor);
		if(usuarioVendedor == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<UsuarioVendedor>(usuarioVendedor, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/UsuarioVendedor", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<UsuarioVendedor>> getUsuarioVendedorByName(@RequestParam(value = "name", required = false) String name){

		List<UsuarioVendedor> usuarioVendedorList = new ArrayList<>();

		if(name == null) {

			usuarioVendedorList = _usuarioVendedorService.getUsuarioVendedorList();

			if(usuarioVendedorList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<UsuarioVendedor>>(usuarioVendedorList, HttpStatus.OK);

			}

		} else {

			UsuarioVendedor usuarioVendedor = _usuarioVendedorService.getUsuarioVendedorByName(name);

			if(usuarioVendedor == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			usuarioVendedorList.add(usuarioVendedor);
			return new ResponseEntity<List<UsuarioVendedor>>(usuarioVendedorList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/UsuarioVendedor", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createUsuarioVendedor(@RequestBody UsuarioVendedor usuarioVendedor, UriComponentsBuilder uriComponentsBuilder){

		if(usuarioVendedor.getNombre().equals(null)||usuarioVendedor.getNombre().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_usuarioVendedorService.getUsuarioVendedorByName(usuarioVendedor.getNombre()) != null) {

			return new ResponseEntity("The UsuarioVendedor already exist", HttpStatus.CONFLICT);

		}

		_usuarioVendedorService.createUsuarioVendedor(usuarioVendedor);
		UsuarioVendedor newUsuarioVendedor = _usuarioVendedorService.getUsuarioVendedorByName(usuarioVendedor.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/UsuarioVendedor/{id}")
				.buildAndExpand(newUsuarioVendedor.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/UsuarioVendedor/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<UsuarioVendedor> updateUsuarioVendedor(@PathVariable("id") Long idUsuarioVendedor, @RequestBody UsuarioVendedor usuarioVendedor){

		if(idUsuarioVendedor == null || idUsuarioVendedor <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		UsuarioVendedor newUsuarioVendedor = _usuarioVendedorService.getUsuarioVendedorById(idUsuarioVendedor);
		if(newUsuarioVendedor == null) {

			return new ResponseEntity("There's no UsuarioVendedor with the id", HttpStatus.CONFLICT);

		}

		newUsuarioVendedor.setCodigo(usuarioVendedor.getCodigo());
		newUsuarioVendedor.setNombre(usuarioVendedor.getNombre());
		newUsuarioVendedor.setUsuario(usuarioVendedor.getUsuario());
		newUsuarioVendedor.setStatReg(usuarioVendedor.getStatReg());

		_usuarioVendedorService.updateUsuarioVendedor(newUsuarioVendedor);
		return new ResponseEntity<UsuarioVendedor>(newUsuarioVendedor, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/UsuarioVendedor/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteUsuarioVendedorById(@PathVariable("id") Long idUsuarioVendedor){

		if(idUsuarioVendedor == null || idUsuarioVendedor <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		UsuarioVendedor usuarioVendedor = _usuarioVendedorService.getUsuarioVendedorById(idUsuarioVendedor);
		if(usuarioVendedor == null) {

			return new ResponseEntity("Can't remove an inexistent UsuarioVendedor", HttpStatus.CONFLICT);
		}

		_usuarioVendedorService.removeUsuarioVendedor(idUsuarioVendedor);
		return new ResponseEntity(HttpStatus.OK);



	}

}
