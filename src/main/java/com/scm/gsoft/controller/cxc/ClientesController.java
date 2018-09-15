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
import com.scm.gsoft.domain.cxc.Clientes;
import com.scm.gsoft.service.cxc.ClientesService;

@Controller
@RequestMapping("/v1/cxc")
public class ClientesController {

	@Autowired
	private ClientesService _clientesService;

	//GET
	@RequestMapping(value = "/Clientes/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Clientes> getClientesById(@PathVariable("id") Long idClientes){

		if(idClientes == null || idClientes <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Clientes clientes = _clientesService.getClientesById(idClientes);
		if(clientes == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Clientes>(clientes, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Clientes", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Clientes>> getClientesByName(@RequestParam(value = "name", required = false) String name){

		List<Clientes> clientesList = new ArrayList<>();

		if(name == null) {

			clientesList = _clientesService.getClientesList();

			if(clientesList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Clientes>>(clientesList, HttpStatus.OK);

			}

		} else {

			Clientes clientes = _clientesService.getClientesByName(name);

			if(clientes == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			clientesList.add(clientes);
			return new ResponseEntity<List<Clientes>>(clientesList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Clientes", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createClientes(@RequestBody Clientes clientes, UriComponentsBuilder uriComponentsBuilder){

		if(clientes.getEmail().equals(null)||clientes.getEmail().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_clientesService.getClientesByName(clientes.getEmail()) != null) {

			return new ResponseEntity("The Clientes already exist", HttpStatus.CONFLICT);

		}

		_clientesService.createClientes(clientes);
		Clientes newClientes = _clientesService.getClientesByName(clientes.getEmail());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Clientes/{id}")
				.buildAndExpand(newClientes.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Clientes/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Clientes> updateClientes(@PathVariable("id") Long idClientes, @RequestBody Clientes clientes){

		if(idClientes == null || idClientes <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Clientes newClientes = _clientesService.getClientesById(idClientes);
		if(newClientes == null) {

			return new ResponseEntity("There's no Clientes with the id", HttpStatus.CONFLICT);

		}

		newClientes.setUsuario(clientes.getUsuario());
		newClientes.setStatReg(clientes.getStatReg());

		_clientesService.updateClientes(newClientes);
		return new ResponseEntity<Clientes>(newClientes, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Clientes/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteClientesById(@PathVariable("id") Long idClientes){

		if(idClientes == null || idClientes <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Clientes clientes = _clientesService.getClientesById(idClientes);
		if(clientes == null) {

			return new ResponseEntity("Can't remove an inexistent Clientes", HttpStatus.CONFLICT);
		}

		_clientesService.removeClientes(idClientes);
		return new ResponseEntity(HttpStatus.OK);



	}

}
