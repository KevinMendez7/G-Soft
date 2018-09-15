package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.MaestroImsDao;
import com.scm.gsoft.domain.inv.MaestroIms;

@Service("MaestroImsService")
@Transactional
public class MaestroImsServiceImpl implements MaestroImsService {

	@Autowired
	private MaestroImsDao _maestroImsDao;

	@Override
	public List<MaestroIms> getMaestroImsList(){
		return _maestroImsDao.getMaestroImsList();
	}

	@Override
	public MaestroIms getMaestroImsById(Long idMaestroIms) {
		// TODO Auto-generated method stub
		return _maestroImsDao.getMaestroImsById(idMaestroIms);
	}

	@Override
	public MaestroIms getMaestroImsByName(String nameMaestroIms) {
		// TODO Auto-generated method stub
		return _maestroImsDao.getMaestroImsByName(nameMaestroIms);
	}

	@Override
	public void updateMaestroIms(MaestroIms maestroIms) {

		_maestroImsDao.updateMaestroIms(maestroIms);

	}

	@Override
	public void createMaestroIms(MaestroIms maestroIms) {

		_maestroImsDao.createMaestroIms(maestroIms);

	}

	@Override
	public void removeMaestroIms(Long idMaestroIms) {

		_maestroImsDao.removeMaestroIms(idMaestroIms);

	}

}
