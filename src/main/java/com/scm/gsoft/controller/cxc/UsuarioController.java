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
import com.scm.gsoft.domain.cxc.Usuario;
import com.scm.gsoft.service.cxc.UsuarioService;

@Controller("UsuarioControllerCxc")
@RequestMapping("/v1/cxc")
public class UsuarioController {

	@Autowired
	@Qualifier("UsuarioServiceCxc")
	private UsuarioService _usuarioService;

	//GET
	@RequestMapping(value = "/Usuario/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") Long idUsuario){

		if(idUsuario == null || idUsuario <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Usuario usuario = _usuarioService.getUsuarioById(idUsuario);
		if(usuario == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Usuario", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Usuario>> getUsuarioByName(@RequestParam(value = "name", required = false) String name){

		List<Usuario> usuarioList = new ArrayList<>();

		if(name == null) {

			usuarioList = _usuarioService.getUsuarioList();

			if(usuarioList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Usuario>>(usuarioList, HttpStatus.OK);

			}

		} else {

			Usuario usuario = _usuarioService.getUsuarioByName(name);

			if(usuario == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			usuarioList.add(usuario);
			return new ResponseEntity<List<Usuario>>(usuarioList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Usuario", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario, UriComponentsBuilder uriComponentsBuilder){

		if(usuario.getUsuario().equals(null)||usuario.getUsuario().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_usuarioService.getUsuarioByName(usuario.getUsuario()) != null) {

			return new ResponseEntity("The Usuario already exist", HttpStatus.CONFLICT);

		}

		_usuarioService.createUsuario(usuario);
		Usuario newUsuario = _usuarioService.getUsuarioByName(usuario.getUsuario());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Usuario/{id}")
				.buildAndExpand(newUsuario.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Usuario/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") Long idUsuario, @RequestBody Usuario usuario){

		if(idUsuario == null || idUsuario <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Usuario newUsuario = _usuarioService.getUsuarioById(idUsuario);
		if(newUsuario == null) {

			return new ResponseEntity("There's no Usuario with the id", HttpStatus.CONFLICT);

		}
		
		newUsuario.setClave(usuario.getClave());		

		_usuarioService.updateUsuario(newUsuario);
		return new ResponseEntity<Usuario>(newUsuario, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Usuario/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteUsuarioById(@PathVariable("id") Long idUsuario){

		if(idUsuario == null || idUsuario <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Usuario usuario = _usuarioService.getUsuarioById(idUsuario);
		if(usuario == null) {

			return new ResponseEntity("Can't remove an inexistent Usuario", HttpStatus.CONFLICT);
		}

		_usuarioService.removeUsuario(idUsuario);
		return new ResponseEntity(HttpStatus.OK);



	}

}
