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
import com.scm.gsoft.domain.cxc.Bancos;
import com.scm.gsoft.service.cxc.BancosService;

@Controller
@RequestMapping("/v1/cxc")
public class BancoController {
	
	@Autowired
	private BancosService _bancosService;
	
	//GET
	@RequestMapping(value = "/Bancos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Bancos> getBancosById(@PathVariable("id") Long idBanco){
		
		if(idBanco == null || idBanco <= 0) {
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		Bancos bancos = _bancosService.getBancosById(idBanco);
		if(bancos == null) {
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Bancos>(bancos, HttpStatus.OK);
		
	}
	
	//GET
	@RequestMapping(value = "/Bancos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Bancos>> getBancosByName(@RequestParam(value = "name", required = false) String name){
		
		List<Bancos> bancosList = new ArrayList<>();
		
		if(name == null) {
			
			bancosList = _bancosService.getBancosList();
			
			if(bancosList.isEmpty()) {
				
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				
			} else {
				
				return new ResponseEntity<List<Bancos>>(bancosList, HttpStatus.OK);
				
			}
			
		} else {
			
			Bancos bancos = _bancosService.getBancosByName(name);
			
			if(bancos == null) {
				
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			
			bancosList.add(bancos);
			return new ResponseEntity<List<Bancos>>(bancosList, HttpStatus.OK);
		
		}
		
	}
	
	//POST
	@RequestMapping(value = "/Bancos", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createBancos(@RequestBody Bancos bancos, UriComponentsBuilder uriComponentsBuilder){
		
		if(bancos.getNombre().equals(null)||bancos.getNombre().isEmpty()) {
			
			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);					
			
		}
		
		if(_bancosService.getBancosByName(bancos.getNombre()) != null) {
			
			return new ResponseEntity("The Bancos already exist", HttpStatus.CONFLICT);
			
		}
		
		_bancosService.createBancos(bancos);
		Bancos newBancos = _bancosService.getBancosByName(bancos.getNombre());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Bancos/{id}")
				.buildAndExpand(newBancos.getCia())
				.toUri());
		
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		
	}
	
	//PATCH
	@RequestMapping(value = "/Bancos/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Bancos> updateBancos(@PathVariable("id") Long idBancos, @RequestBody Bancos bancos){
		
		if(idBancos == null || idBancos <= 0 ) {
			
			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
			
		}
		
		Bancos newBancos = _bancosService.getBancosById(idBancos);
		if(newBancos == null) {
			
			return new ResponseEntity("There's no Bancos with the id", HttpStatus.CONFLICT);
			
		}
		
		newBancos.setCodigo(bancos.getCodigo());
		newBancos.setNombre(bancos.getNombre());
		newBancos.setUsuario(bancos.getUsuario());
		newBancos.setStatReg(bancos.getStatReg());
		
		_bancosService.updateBancos(newBancos);		
		return new ResponseEntity<Bancos>(newBancos, HttpStatus.OK);
		
	}
	
	//DELETE
	@RequestMapping(value = "/Bancos/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteBancosById(@PathVariable("id") Long idBancos){
		
		if(idBancos == null || idBancos <= 0) {
			
			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}
		
		Bancos bancos = _bancosService.getBancosById(idBancos);
		if(bancos == null) {
					
			return new ResponseEntity("Can't remove an inexistent Bancos", HttpStatus.CONFLICT);
		}
		
		_bancosService.removeBancos(idBancos);
		return new ResponseEntity(HttpStatus.OK);
		
		
		
	}

}
