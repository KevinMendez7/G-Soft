package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.FisicoDao;
import com.scm.gsoft.domain.cxc.Fisico;

@Qualifier("FisicoServiceCxc")
@Service("FisicoServiceCxc")
@Transactional
public class FisicoServiceImpl implements FisicoService {

	@Autowired
	@Qualifier("FisicoDaoCxc")
	private FisicoDao _fisicoDao;

	@Override
	public List<Fisico> getFisicoList(){
		return _fisicoDao.getFisicoList();
	}

	@Override
	public Fisico getFisicoById(Long idFisico) {
		// TODO Auto-generated method stub
		return _fisicoDao.getFisicoById(idFisico);
	}

	@Override
	public Fisico getFisicoByName(String nameFisico) {
		// TODO Auto-generated method stub
		return _fisicoDao.getFisicoByName(nameFisico);
	}

	@Override
	public void updateFisico(Fisico fisico) {

		_fisicoDao.updateFisico(fisico);

	}

	@Override
	public void createFisico(Fisico fisico) {

		_fisicoDao.createFisico(fisico);

	}

	@Override
	public void removeFisico(Long idFisico) {

		_fisicoDao.removeFisico(idFisico);

	}

}
