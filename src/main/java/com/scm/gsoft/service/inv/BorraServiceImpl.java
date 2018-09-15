package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.BorraDao;
import com.scm.gsoft.domain.inv.Borra;

@Service("BorraService")
@Transactional
public class BorraServiceImpl implements BorraService {

	@Autowired
	private BorraDao _borraDao;

	@Override
	public List<Borra> getBorraList(){
		return _borraDao.getBorraList();
	}

	@Override
	public Borra getBorraById(Long idBorra) {
		// TODO Auto-generated method stub
		return _borraDao.getBorraById(idBorra);
	}

	@Override
	public Borra getBorraByName(String nameBorra) {
		// TODO Auto-generated method stub
		return _borraDao.getBorraByName(nameBorra);
	}

	@Override
	public void updateBorra(Borra borra) {

		_borraDao.updateBorra(borra);

	}

	@Override
	public void createBorra(Borra borra) {

		_borraDao.createBorra(borra);

	}

	@Override
	public void removeBorra(Long idBorra) {

		_borraDao.removeBorra(idBorra);

	}

}
