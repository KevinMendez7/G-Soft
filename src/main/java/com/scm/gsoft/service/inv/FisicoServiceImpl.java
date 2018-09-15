package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.FisicoDao;
import com.scm.gsoft.domain.inv.Fisico;

@Service("FisicoService")
@Transactional
public class FisicoServiceImpl implements FisicoService {

	@Autowired
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
