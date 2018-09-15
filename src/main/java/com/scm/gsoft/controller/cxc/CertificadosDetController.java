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
import com.scm.gsoft.domain.cxc.CertificadosDet;
import com.scm.gsoft.service.cxc.CertificadosDetService;

@Controller
@RequestMapping("/v1/cxc")
public class CertificadosDetController {

	@Autowired
	private CertificadosDetService _certificadosDetService;

	//GET
	@RequestMapping(value = "/CertificadosDet/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<CertificadosDet> getCertificadosDetById(@PathVariable("id") Long idCertificadosDet){

		if(idCertificadosDet == null || idCertificadosDet <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		CertificadosDet certificadosDet = _certificadosDetService.getCertificadosDetById(idCertificadosDet);
		if(certificadosDet == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<CertificadosDet>(certificadosDet, HttpStatus.OK);

	}

	//GET
	@RequestMapping(value = "/CertificadosDet", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<CertificadosDet>> getCertificadosDetByName(@RequestParam(value = "name", required = false) String name){

		List<CertificadosDet> certificadosDetList = new ArrayList<>();

		if(name == null) {

			certificadosDetList = _certificadosDetService.getCertificadosDetList();

			if(certificadosDetList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);

			} else {

				return new ResponseEntity<List<CertificadosDet>>(certificadosDetList, HttpStatus.OK);

			}

		} else {

			CertificadosDet certificadosDet = _certificadosDetService.getCertificadosDetByName(name);

			if(certificadosDet == null) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			certificadosDetList.add(certificadosDet);
			return new ResponseEntity<List<CertificadosDet>>(certificadosDetList, HttpStatus.OK);

		}

	}

	//POST
	@RequestMapping(value = "/CertificadosDet", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCertificadosDet(@RequestBody CertificadosDet certificadosDet, UriComponentsBuilder uriComponentsBuilder){

		if(certificadosDet.getNumeroCert().equals(null)||certificadosDet.getNumeroCert().isEmpty()) {

			return new ResponseEntity("Name can't be null", HttpStatus.CONFLICT);

		}

		if(_certificadosDetService.getCertificadosDetByName(certificadosDet.getNumeroCert()) != null) {

			return new ResponseEntity("The CertificadosDet already exist", HttpStatus.CONFLICT);

		}

		_certificadosDetService.createCertificadosDet(certificadosDet);
		CertificadosDet newCertificadosDet = _certificadosDetService.getCertificadosDetByName(certificadosDet.getNumeroCert());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder
				.path("/v1/CertificadosDet/{id}")
				.buildAndExpand(newCertificadosDet.getCia())
				.toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//PATCH
	@RequestMapping(value = "/CertificadosDet/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<CertificadosDet> updateCertificadosDet(@PathVariable("id") Long idCertificadosDet, @RequestBody CertificadosDet certificadosDet){

		if(idCertificadosDet == null || idCertificadosDet <= 0 ) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);

		}

		CertificadosDet newCertificadosDet = _certificadosDetService.getCertificadosDetById(idCertificadosDet);
		if(newCertificadosDet == null) {

			return new ResponseEntity("There's no CertificadosDet with the id", HttpStatus.CONFLICT);

		}

		newCertificadosDet.setUsuario(certificadosDet.getUsuario());
		newCertificadosDet.setStatReg(certificadosDet.getStatReg());

		_certificadosDetService.updateCertificadosDet(newCertificadosDet);
		return new ResponseEntity<CertificadosDet>(newCertificadosDet, HttpStatus.OK);

	}

	//DELETE
	@RequestMapping(value = "/CertificadosDet/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteCertificadosDetById(@PathVariable("id") Long idCertificadosDet){

		if(idCertificadosDet == null || idCertificadosDet <= 0) {

			return new ResponseEntity("Id can't be null, 0 or less", HttpStatus.CONFLICT);
		}

		CertificadosDet certificadosDet = _certificadosDetService.getCertificadosDetById(idCertificadosDet);
		if(certificadosDet == null) {

			return new ResponseEntity("Can't remove an inexistent CertificadosDet", HttpStatus.CONFLICT);
		}

		_certificadosDetService.removeCertificadosDet(idCertificadosDet);
		return new ResponseEntity(HttpStatus.OK);



	}

}
