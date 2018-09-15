package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.Inv2SDao;
import com.scm.gsoft.domain.inv.Inv2S;

@Service("Inv2SService")
@Transactional
public class Inv2SServiceImpl implements Inv2SService {

	@Autowired
	private Inv2SDao _inv2SDao;

	@Override
	public List<Inv2S> getInv2SList(){
		return _inv2SDao.getInv2SList();
	}

	@Override
	public Inv2S getInv2SById(Long idInv2S) {
		// TODO Auto-generated method stub
		return _inv2SDao.getInv2SById(idInv2S);
	}

	@Override
	public Inv2S getInv2SByName(String nameInv2S) {
		// TODO Auto-generated method stub
		return _inv2SDao.getInv2SByName(nameInv2S);
	}

	@Override
	public void updateInv2S(Inv2S inv2S) {

		_inv2SDao.updateInv2S(inv2S);

	}

	@Override
	public void createInv2S(Inv2S inv2S) {

		_inv2SDao.createInv2S(inv2S);

	}

	@Override
	public void removeInv2S(Long idInv2S) {

		_inv2SDao.removeInv2S(idInv2S);

	}

}
