package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.MaebodPreciosHistDao;
import com.scm.gsoft.domain.inv.MaebodPreciosHist;

@Service("MaebodPreciosHistService")
@Transactional
public class MaebodPreciosHistServiceImpl implements MaebodPreciosHistService {

	@Autowired
	private MaebodPreciosHistDao _maebodPreciosHistDao;

	@Override
	public List<MaebodPreciosHist> getMaebodPreciosHistList(){
		return _maebodPreciosHistDao.getMaebodPreciosHistList();
	}

	@Override
	public MaebodPreciosHist getMaebodPreciosHistById(Long idMaebodPreciosHist) {
		// TODO Auto-generated method stub
		return _maebodPreciosHistDao.getMaebodPreciosHistById(idMaebodPreciosHist);
	}

	@Override
	public MaebodPreciosHist getMaebodPreciosHistByName(String nameMaebodPreciosHist) {
		// TODO Auto-generated method stub
		return _maebodPreciosHistDao.getMaebodPreciosHistByName(nameMaebodPreciosHist);
	}

	@Override
	public void updateMaebodPreciosHist(MaebodPreciosHist maebodPreciosHist) {

		_maebodPreciosHistDao.updateMaebodPreciosHist(maebodPreciosHist);

	}

	@Override
	public void createMaebodPreciosHist(MaebodPreciosHist maebodPreciosHist) {

		_maebodPreciosHistDao.createMaebodPreciosHist(maebodPreciosHist);

	}

	@Override
	public void removeMaebodPreciosHist(Long idMaebodPreciosHist) {

		_maebodPreciosHistDao.removeMaebodPreciosHist(idMaebodPreciosHist);

	}

}
