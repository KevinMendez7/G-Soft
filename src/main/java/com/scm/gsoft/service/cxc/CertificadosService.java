package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Certificados;

public interface CertificadosService {

	List<Certificados> getCertificadosList();

	Certificados getCertificadosById(Long idCertificados);

	Certificados getCertificadosByName(String nameCertificados);

	void updateCertificados(Certificados certificados);

	void createCertificados(Certificados certificados);

	void removeCertificados(Long idCertificados);

}
