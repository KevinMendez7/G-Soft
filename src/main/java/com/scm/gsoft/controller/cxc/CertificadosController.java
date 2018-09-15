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
import com.scm.gsoft.domain.cxc.Certificados;
import com.scm.gsoft.service.cxc.CertificadosService;

@Controller
@RequestMapping("/v1/cxc")
public class CertificadosController {

	@Autowired
	private CertificadosService _certificadosService;

	//GET
	@RequestMapping(value = "/Certificados/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Certificados> getCertificadosById(@PathVariable("id") Long idCertificados){

		if(idCertificados == null || idCertificados <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		Certificados certificados = _certificadosService.getCertificadosById(idCertificados);
		if(certificados == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Certificados>(certificados, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/Certificados", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Certificados>> getCertificadosByName(@RequestParam(value = "name", required = false) String name){

		List<Certificados> certificadosList = new ArrayList<>();

		if(name == null) {

			certificadosList = _certificadosService.getCertificadosList();

			if(certificadosList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<Certificados>>(certificadosList, HttpStatus.OK);

			}

		} else {

			Certificados certificados = _certificadosService.getCertificadosByName(name);

			if(certificados == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			certificadosList.add(certificados);
			return new ResponseEntity<List<Certificados>>(certificadosList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/Certificados", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCertificados(@RequestBody Certificados certificados, UriComponentsBuilder uriComponentsBuilder){

		if(certificados.getNumeroCert().equals(null)||certificados.getNumeroCert().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_certificadosService.getCertificadosByName(certificados.getNumeroCert()) != null) {

			return new ResponseEntity("The Certificados already exist", HttpStatus.CONFLICT);

		}

		_certificadosService.createCertificados(certificados);
		Certificados newCertificados = _certificadosService.getCertificadosByName(certificados.getNumeroCert());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/Certificados/{id}")
				.buildAndExpand(newCertificados.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/Certificados/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<Certificados> updateCertificados(@PathVariable("id") Long idCertificados, @RequestBody Certificados certificados){

		if(idCertificados == null || idCertificados <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		Certificados newCertificados = _certificadosService.getCertificadosById(idCertificados);
		if(newCertificados == null) {

			return new ResponseEntity("There's no Certificados with the id", HttpStatus.CONFLICT);

		}
		
		newCertificados.setUsuario(certificados.getUsuario());
		newCertificados.setStatReg(certificados.getStatReg());

		_certificadosService.updateCertificados(newCertificados);
		return new ResponseEntity<Certificados>(newCertificados, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/Certificados/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteCertificadosById(@PathVariable("id") Long idCertificados){

		if(idCertificados == null || idCertificados <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		Certificados certificados = _certificadosService.getCertificadosById(idCertificados);
		if(certificados == null) {

			return new ResponseEntity("Can't remove an inexistent Certificados", HttpStatus.CONFLICT);
		}

		_certificadosService.removeCertificados(idCertificados);
		return new ResponseEntity(HttpStatus.OK);



	}

}
