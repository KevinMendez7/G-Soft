package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Certificados;

@Repository
@Transactional
public class CertificadosDaoImpl extends AbstractSession implements CertificadosDao {

	@Override
	public List<Certificados> getCertificadosList(){
		return (List<Certificados>) getCxcSession().createQuery("from Certificados").list();
	}

	@Override
	public Certificados getCertificadosById(Long idCertificados) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Certificados.class, idCertificados);
	}

	@Override
	public Certificados getCertificadosByName(String nameCertificados) {
		// TODO Auto-generated method stub
		return (Certificados) getCxcSession().createQuery("from Certificados where nombre = :nameCertificados")
				.setParameter("nameCertificados", nameCertificados).uniqueResult();
	}

	@Override
	public void updateCertificados(Certificados certificados) {
		getCxcSession().update(certificados);

	}

	@Override
	public void createCertificados(Certificados certificados) {

		getCxcSession().persist(certificados);

	}

	@Override
	public void removeCertificados(Long idCertificados) {

		Certificados certificados = getCertificadosById(idCertificados);
		if(certificados != null) {
			getCxcSession().delete(certificados);
		}

	}

}
