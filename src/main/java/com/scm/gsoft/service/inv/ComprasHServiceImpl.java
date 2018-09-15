package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.ComprasHDao;
import com.scm.gsoft.domain.inv.ComprasH;

@Service("ComprasHService")
@Transactional
public class ComprasHServiceImpl implements ComprasHService {

	@Autowired
	private ComprasHDao _comprasHDao;

	@Override
	public List<ComprasH> getComprasHList(){
		return _comprasHDao.getComprasHList();
	}

	@Override
	public ComprasH getComprasHById(Long idComprasH) {
		// TODO Auto-generated method stub
		return _comprasHDao.getComprasHById(idComprasH);
	}

	@Override
	public ComprasH getComprasHByName(String nameComprasH) {
		// TODO Auto-generated method stub
		return _comprasHDao.getComprasHByName(nameComprasH);
	}

	@Override
	public void updateComprasH(ComprasH comprasH) {

		_comprasHDao.updateComprasH(comprasH);

	}

	@Override
	public void createComprasH(ComprasH comprasH) {

		_comprasHDao.createComprasH(comprasH);

	}

	@Override
	public void removeComprasH(Long idComprasH) {

		_comprasHDao.removeComprasH(idComprasH);

	}

}
