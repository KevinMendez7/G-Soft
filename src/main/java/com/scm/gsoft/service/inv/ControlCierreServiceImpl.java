package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.ControlCierreDao;
import com.scm.gsoft.domain.inv.ControlCierre;

@Service("ControlCierreService")
@Transactional
public class ControlCierreServiceImpl implements ControlCierreService {

	@Autowired
	private ControlCierreDao _controlCierreDao;

	@Override
	public List<ControlCierre> getControlCierreList(){
		return _controlCierreDao.getControlCierreList();
	}

	@Override
	public ControlCierre getControlCierreById(Long idControlCierre) {
		// TODO Auto-generated method stub
		return _controlCierreDao.getControlCierreById(idControlCierre);
	}

	@Override
	public ControlCierre getControlCierreByName(String nameControlCierre) {
		// TODO Auto-generated method stub
		return _controlCierreDao.getControlCierreByName(nameControlCierre);
	}

	@Override
	public void updateControlCierre(ControlCierre controlCierre) {

		_controlCierreDao.updateControlCierre(controlCierre);

	}

	@Override
	public void createControlCierre(ControlCierre controlCierre) {

		_controlCierreDao.createControlCierre(controlCierre);

	}

	@Override
	public void removeControlCierre(Long idControlCierre) {

		_controlCierreDao.removeControlCierre(idControlCierre);

	}

}
