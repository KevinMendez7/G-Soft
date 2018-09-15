package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.CotizaHDao;
import com.scm.gsoft.domain.cxc.CotizaH;

@Service("CotizaHService")
@Transactional
public class CotizaHServiceImpl implements CotizaHService {

	@Autowired
	private CotizaHDao _cotizaHDao;

	@Override
	public List<CotizaH> getCotizaHList(){
		return _cotizaHDao.getCotizaHList();
	}

	@Override
	public CotizaH getCotizaHById(Long idCotizaH) {
		// TODO Auto-generated method stub
		return _cotizaHDao.getCotizaHById(idCotizaH);
	}

	@Override
	public CotizaH getCotizaHByName(String nameCotizaH) {
		// TODO Auto-generated method stub
		return _cotizaHDao.getCotizaHByName(nameCotizaH);
	}

	@Override
	public void updateCotizaH(CotizaH cotizaH) {

		_cotizaHDao.updateCotizaH(cotizaH);

	}

	@Override
	public void createCotizaH(CotizaH cotizaH) {

		_cotizaHDao.createCotizaH(cotizaH);

	}

	@Override
	public void removeCotizaH(Long idCotizaH) {

		_cotizaHDao.removeCotizaH(idCotizaH);

	}

}
