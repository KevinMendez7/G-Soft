package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.MaebodDao;
import com.scm.gsoft.domain.inv.Maebod;

@Service("MaebodService")
@Transactional
public class MaebodServiceImpl implements MaebodService {

	@Autowired
	private MaebodDao _maebodDao;

	@Override
	public List<Maebod> getMaebodList(){
		return _maebodDao.getMaebodList();
	}

	@Override
	public Maebod getMaebodById(Long idMaebod) {
		// TODO Auto-generated method stub
		return _maebodDao.getMaebodById(idMaebod);
	}

	@Override
	public Maebod getMaebodByName(String nameMaebod) {
		// TODO Auto-generated method stub
		return _maebodDao.getMaebodByName(nameMaebod);
	}

	@Override
	public void updateMaebod(Maebod maebod) {

		_maebodDao.updateMaebod(maebod);

	}

	@Override
	public void createMaebod(Maebod maebod) {

		_maebodDao.createMaebod(maebod);

	}

	@Override
	public void removeMaebod(Long idMaebod) {

		_maebodDao.removeMaebod(idMaebod);

	}

}
