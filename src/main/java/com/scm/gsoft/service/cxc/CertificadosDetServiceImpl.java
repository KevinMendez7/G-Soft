package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.CertificadosDetDao;
import com.scm.gsoft.domain.cxc.CertificadosDet;

@Service("CertificadosDetService")
@Transactional
public class CertificadosDetServiceImpl implements CertificadosDetService {

	@Autowired
	private CertificadosDetDao _certificadosDetDao;

	@Override
	public List<CertificadosDet> getCertificadosDetList(){
		return _certificadosDetDao.getCertificadosDetList();
	}

	@Override
	public CertificadosDet getCertificadosDetById(Long idCertificadosDet) {
		// TODO Auto-generated method stub
		return _certificadosDetDao.getCertificadosDetById(idCertificadosDet);
	}

	@Override
	public CertificadosDet getCertificadosDetByName(String nameCertificadosDet) {
		// TODO Auto-generated method stub
		return _certificadosDetDao.getCertificadosDetByName(nameCertificadosDet);
	}

	@Override
	public void updateCertificadosDet(CertificadosDet certificadosDet) {

		_certificadosDetDao.updateCertificadosDet(certificadosDet);

	}

	@Override
	public void createCertificadosDet(CertificadosDet certificadosDet) {

		_certificadosDetDao.createCertificadosDet(certificadosDet);

	}

	@Override
	public void removeCertificadosDet(Long idCertificadosDet) {

		_certificadosDetDao.removeCertificadosDet(idCertificadosDet);

	}

}
