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
import com.scm.gsoft.domain.cxc.ClientesSinCompras;
import com.scm.gsoft.service.cxc.ClientesSinComprasService;

@Controller
@RequestMapping("/v1/cxc")
public class ClientesSinComprasController {

	@Autowired
	private ClientesSinComprasService _clientesSinComprasService;

	//GET
	@RequestMapping(value = "/ClientesSinCompras/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<ClientesSinCompras> getClientesSinComprasById(@PathVariable("id") Long idClientesSinCompras){

		if(idClientesSinCompras == null || idClientesSinCompras <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		ClientesSinCompras clientesSinCompras = _clientesSinComprasService.getClientesSinComprasById(idClientesSinCompras);
		if(clientesSinCompras == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<ClientesSinCompras>(clientesSinCompras, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/ClientesSinCompras", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<ClientesSinCompras>> getClientesSinComprasByName(@RequestParam(value = "name", required = false) String name){

		List<ClientesSinCompras> clientesSinComprasList = new ArrayList<>();

		if(name == null) {

			clientesSinComprasList = _clientesSinComprasService.getClientesSinComprasList();

			if(clientesSinComprasList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<ClientesSinCompras>>(clientesSinComprasList, HttpStatus.OK);

			}

		} else {

			ClientesSinCompras clientesSinCompras = _clientesSinComprasService.getClientesSinComprasByName(name);

			if(clientesSinCompras == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			clientesSinComprasList.add(clientesSinCompras);
			return new ResponseEntity<List<ClientesSinCompras>>(clientesSinComprasList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/ClientesSinCompras", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createClientesSinCompras(@RequestBody ClientesSinCompras clientesSinCompras, UriComponentsBuilder uriComponentsBuilder){

		if(clientesSinCompras.getCodigo().equals(null)||clientesSinCompras.getCodigo().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_clientesSinComprasService.getClientesSinComprasByName(clientesSinCompras.getCodigo()) != null) {

			return new ResponseEntity("The ClientesSinCompras already exist", HttpStatus.CONFLICT);

		}

		_clientesSinComprasService.createClientesSinCompras(clientesSinCompras);
		ClientesSinCompras newClientesSinCompras = _clientesSinComprasService.getClientesSinComprasByName(clientesSinCompras.getCodigo());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/ClientesSinCompras/{id}")
				.buildAndExpand(newClientesSinCompras.getIdClientes())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/ClientesSinCompras/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<ClientesSinCompras> updateClientesSinCompras(@PathVariable("id") Long idClientesSinCompras, @RequestBody ClientesSinCompras clientesSinCompras){

		if(idClientesSinCompras == null || idClientesSinCompras <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		ClientesSinCompras newClientesSinCompras = _clientesSinComprasService.getClientesSinComprasById(idClientesSinCompras);
		if(newClientesSinCompras == null) {

			return new ResponseEntity("There's no ClientesSinCompras with the id", HttpStatus.CONFLICT);

		}

		newClientesSinCompras.setCodigo(clientesSinCompras.getCodigo());

		_clientesSinComprasService.updateClientesSinCompras(newClientesSinCompras);
		return new ResponseEntity<ClientesSinCompras>(newClientesSinCompras, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/ClientesSinCompras/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteClientesSinComprasById(@PathVariable("id") Long idClientesSinCompras){

		if(idClientesSinCompras == null || idClientesSinCompras <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		ClientesSinCompras clientesSinCompras = _clientesSinComprasService.getClientesSinComprasById(idClientesSinCompras);
		if(clientesSinCompras == null) {

			return new ResponseEntity("Can't remove an inexistent ClientesSinCompras", HttpStatus.CONFLICT);
		}

		_clientesSinComprasService.removeClientesSinCompras(idClientesSinCompras);
		return new ResponseEntity(HttpStatus.OK);



	}

}
