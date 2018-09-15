package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.CertificadosDet;

@Repository
@Transactional
public class CertificadosDetDaoImpl extends AbstractSession implements CertificadosDetDao {

	@Override
	public List<CertificadosDet> getCertificadosDetList(){
		return (List<CertificadosDet>) getCxcSession().createQuery("from CertificadosDet").list();
	}

	@Override
	public CertificadosDet getCertificadosDetById(Long idCertificadosDet) {
		// TODO Auto-generated method stub
		return getCxcSession().get(CertificadosDet.class, idCertificadosDet);
	}

	@Override
	public CertificadosDet getCertificadosDetByName(String nameCertificadosDet) {
		// TODO Auto-generated method stub
		return (CertificadosDet) getCxcSession().createQuery("from CertificadosDet where nombre = :nameCertificadosDet")
				.setParameter("nameCertificadosDet", nameCertificadosDet).uniqueResult();
	}

	@Override
	public void updateCertificadosDet(CertificadosDet certificadosDet) {
		getCxcSession().update(certificadosDet);

	}

	@Override
	public void createCertificadosDet(CertificadosDet certificadosDet) {

		getCxcSession().persist(certificadosDet);

	}

	@Override
	public void removeCertificadosDet(Long idCertificadosDet) {

		CertificadosDet certificadosDet = getCertificadosDetById(idCertificadosDet);
		if(certificadosDet != null) {
			getCxcSession().delete(certificadosDet);
		}

	}

}
