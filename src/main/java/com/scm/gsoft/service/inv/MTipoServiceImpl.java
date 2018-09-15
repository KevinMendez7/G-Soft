package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.MTipoDao;
import com.scm.gsoft.domain.inv.MTipo;

@Service("MTipoService")
@Transactional
public class MTipoServiceImpl implements MTipoService {

	@Autowired
	private MTipoDao _mTipoDao;

	@Override
	public List<MTipo> getMTipoList(){
		return _mTipoDao.getMTipoList();
	}

	@Override
	public MTipo getMTipoById(Long idMTipo) {
		// TODO Auto-generated method stub
		return _mTipoDao.getMTipoById(idMTipo);
	}

	@Override
	public MTipo getMTipoByName(String nameMTipo) {
		// TODO Auto-generated method stub
		return _mTipoDao.getMTipoByName(nameMTipo);
	}

	@Override
	public void updateMTipo(MTipo mTipo) {

		_mTipoDao.updateMTipo(mTipo);

	}

	@Override
	public void createMTipo(MTipo mTipo) {

		_mTipoDao.createMTipo(mTipo);

	}

	@Override
	public void removeMTipo(Long idMTipo) {

		_mTipoDao.removeMTipo(idMTipo);

	}

}
