package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.CertificadosDet;

public interface CertificadosDetService {

	List<CertificadosDet> getCertificadosDetList();

	CertificadosDet getCertificadosDetById(Long idCertificadosDet);

	CertificadosDet getCertificadosDetByName(String nameCertificadosDet);

	void updateCertificadosDet(CertificadosDet certificadosDet);

	void createCertificadosDet(CertificadosDet certificadosDet);

	void removeCertificadosDet(Long idCertificadosDet);

}
