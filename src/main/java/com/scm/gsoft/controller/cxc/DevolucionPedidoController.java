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
import com.scm.gsoft.domain.cxc.DevolucionPedido;
import com.scm.gsoft.service.cxc.DevolucionPedidoService;

@Controller
@RequestMapping("/v1/cxc")
public class DevolucionPedidoController {

	@Autowired
	private DevolucionPedidoService _devolucionPedidoService;

	//GET
	@RequestMapping(value = "/DevolucionPedido/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<DevolucionPedido> getDevolucionPedidoById(@PathVariable("id") Long idDevolucionPedido){

		if(idDevolucionPedido == null || idDevolucionPedido <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		DevolucionPedido devolucionPedido = _devolucionPedidoService.getDevolucionPedidoById(idDevolucionPedido);
		if(devolucionPedido == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<DevolucionPedido>(devolucionPedido, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/DevolucionPedido", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<DevolucionPedido>> getDevolucionPedidoByName(@RequestParam(value = "name", required = false) String name){

		List<DevolucionPedido> devolucionPedidoList = new ArrayList<>();

		if(name == null) {

			devolucionPedidoList = _devolucionPedidoService.getDevolucionPedidoList();

			if(devolucionPedidoList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<DevolucionPedido>>(devolucionPedidoList, HttpStatus.OK);

			}

		} else {

			DevolucionPedido devolucionPedido = _devolucionPedidoService.getDevolucionPedidoByName(name);

			if(devolucionPedido == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			devolucionPedidoList.add(devolucionPedido);
			return new ResponseEntity<List<DevolucionPedido>>(devolucionPedidoList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/DevolucionPedido", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createDevolucionPedido(@RequestBody DevolucionPedido devolucionPedido, UriComponentsBuilder uriComponentsBuilder){

		if(devolucionPedido.getNumeroDev().equals(null)||devolucionPedido.getNumeroDev().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_devolucionPedidoService.getDevolucionPedidoByName(devolucionPedido.getNumeroDev()) != null) {

			return new ResponseEntity("The DevolucionPedido already exist", HttpStatus.CONFLICT);

		}

		_devolucionPedidoService.createDevolucionPedido(devolucionPedido);
		DevolucionPedido newDevolucionPedido = _devolucionPedidoService.getDevolucionPedidoByName(devolucionPedido.getNumeroDev());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/DevolucionPedido/{id}")
				.buildAndExpand(newDevolucionPedido.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/DevolucionPedido/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<DevolucionPedido> updateDevolucionPedido(@PathVariable("id") Long idDevolucionPedido, @RequestBody DevolucionPedido devolucionPedido){

		if(idDevolucionPedido == null || idDevolucionPedido <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		DevolucionPedido newDevolucionPedido = _devolucionPedidoService.getDevolucionPedidoById(idDevolucionPedido);
		if(newDevolucionPedido == null) {

			return new ResponseEntity("There's no DevolucionPedido with the id", HttpStatus.CONFLICT);

		}

		newDevolucionPedido.setUsuario(devolucionPedido.getUsuario());
		newDevolucionPedido.setStatReg(devolucionPedido.getStatReg());

		_devolucionPedidoService.updateDevolucionPedido(newDevolucionPedido);
		return new ResponseEntity<DevolucionPedido>(newDevolucionPedido, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/DevolucionPedido/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteDevolucionPedidoById(@PathVariable("id") Long idDevolucionPedido){

		if(idDevolucionPedido == null || idDevolucionPedido <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		DevolucionPedido devolucionPedido = _devolucionPedidoService.getDevolucionPedidoById(idDevolucionPedido);
		if(devolucionPedido == null) {

			return new ResponseEntity("Can't remove an inexistent DevolucionPedido", HttpStatus.CONFLICT);
		}

		_devolucionPedidoService.removeDevolucionPedido(idDevolucionPedido);
		return new ResponseEntity(HttpStatus.OK);



	}

}
