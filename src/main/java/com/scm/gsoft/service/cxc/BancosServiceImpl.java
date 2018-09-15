package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.BancosDao;
import com.scm.gsoft.domain.cxc.Bancos;

@Service("BancosService")
@Transactional
public class BancosServiceImpl implements BancosService {

	@Autowired
	private BancosDao _bancosDao;

	@Override
	public List<Bancos> getBancosList(){
		return _bancosDao.getBancosList();
	}

	@Override
	public Bancos getBancosById(Long idBancos) {
		// TODO Auto-generated method stub
		return _bancosDao.getBancosById(idBancos);
	}

	@Override
	public Bancos getBancosByName(String nameBancos) {
		// TODO Auto-generated method stub
		return _bancosDao.getBancosByName(nameBancos);
	}

	@Override
	public void updateBancos(Bancos bancos) {

		_bancosDao.updateBancos(bancos);

	}

	@Override
	public void createBancos(Bancos bancos) {

		_bancosDao.createBancos(bancos);

	}

	@Override
	public void removeBancos(Long idBancos) {

		_bancosDao.removeBancos(idBancos);

	}

}
