package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.MaebodDetDao;
import com.scm.gsoft.domain.inv.MaebodDet;

@Service("MaebodDetService")
@Transactional
public class MaebodDetServiceImpl implements MaebodDetService {

	@Autowired
	private MaebodDetDao _maebodDetDao;

	@Override
	public List<MaebodDet> getMaebodDetList(){
		return _maebodDetDao.getMaebodDetList();
	}

	@Override
	public MaebodDet getMaebodDetById(Long idMaebodDet) {
		// TODO Auto-generated method stub
		return _maebodDetDao.getMaebodDetById(idMaebodDet);
	}

	@Override
	public MaebodDet getMaebodDetByName(String nameMaebodDet) {
		// TODO Auto-generated method stub
		return _maebodDetDao.getMaebodDetByName(nameMaebodDet);
	}

	@Override
	public void updateMaebodDet(MaebodDet maebodDet) {

		_maebodDetDao.updateMaebodDet(maebodDet);

	}

	@Override
	public void createMaebodDet(MaebodDet maebodDet) {

		_maebodDetDao.createMaebodDet(maebodDet);

	}

	@Override
	public void removeMaebodDet(Long idMaebodDet) {

		_maebodDetDao.removeMaebodDet(idMaebodDet);

	}

}
