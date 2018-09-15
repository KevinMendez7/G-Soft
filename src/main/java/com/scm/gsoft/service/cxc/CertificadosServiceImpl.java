package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.CertificadosDao;
import com.scm.gsoft.domain.cxc.Certificados;

@Service("CertificadosService")
@Transactional
public class CertificadosServiceImpl implements CertificadosService {

	@Autowired
	private CertificadosDao _certificadosDao;

	@Override
	public List<Certificados> getCertificadosList(){
		return _certificadosDao.getCertificadosList();
	}

	@Override
	public Certificados getCertificadosById(Long idCertificados) {
		// TODO Auto-generated method stub
		return _certificadosDao.getCertificadosById(idCertificados);
	}

	@Override
	public Certificados getCertificadosByName(String nameCertificados) {
		// TODO Auto-generated method stub
		return _certificadosDao.getCertificadosByName(nameCertificados);
	}

	@Override
	public void updateCertificados(Certificados certificados) {

		_certificadosDao.updateCertificados(certificados);

	}

	@Override
	public void createCertificados(Certificados certificados) {

		_certificadosDao.createCertificados(certificados);

	}

	@Override
	public void removeCertificados(Long idCertificados) {

		_certificadosDao.removeCertificados(idCertificados);

	}

}
