package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.MecanismoDao;
import com.scm.gsoft.domain.inv.Mecanismo;

@Service("MecanismoService")
@Transactional
public class MecanismoServiceImpl implements MecanismoService {

	@Autowired
	private MecanismoDao _mecanismoDao;

	@Override
	public List<Mecanismo> getMecanismoList(){
		return _mecanismoDao.getMecanismoList();
	}

	@Override
	public Mecanismo getMecanismoById(Long idMecanismo) {
		// TODO Auto-generated method stub
		return _mecanismoDao.getMecanismoById(idMecanismo);
	}

	@Override
	public Mecanismo getMecanismoByName(String nameMecanismo) {
		// TODO Auto-generated method stub
		return _mecanismoDao.getMecanismoByName(nameMecanismo);
	}

	@Override
	public void updateMecanismo(Mecanismo mecanismo) {

		_mecanismoDao.updateMecanismo(mecanismo);

	}

	@Override
	public void createMecanismo(Mecanismo mecanismo) {

		_mecanismoDao.createMecanismo(mecanismo);

	}

	@Override
	public void removeMecanismo(Long idMecanismo) {

		_mecanismoDao.removeMecanismo(idMecanismo);

	}

}
