package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.MTipoDao;
import com.scm.gsoft.domain.cxc.MTipo;

@Qualifier("MTipoServiceCxc")
@Service("MTipoServiceCxc")
@Transactional
public class MTipoServiceImpl implements MTipoService {

	@Autowired
	@Qualifier("MTipoDaoCxc")
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
