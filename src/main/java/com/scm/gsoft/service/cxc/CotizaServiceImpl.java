package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.CotizaDao;
import com.scm.gsoft.domain.cxc.Cotiza;

@Service("CotizaService")
@Transactional
public class CotizaServiceImpl implements CotizaService {

	@Autowired
	private CotizaDao _cotizaDao;

	@Override
	public List<Cotiza> getCotizaList(){
		return _cotizaDao.getCotizaList();
	}

	@Override
	public Cotiza getCotizaById(Long idCotiza) {
		// TODO Auto-generated method stub
		return _cotizaDao.getCotizaById(idCotiza);
	}

	@Override
	public Cotiza getCotizaByName(String nameCotiza) {
		// TODO Auto-generated method stub
		return _cotizaDao.getCotizaByName(nameCotiza);
	}

	@Override
	public void updateCotiza(Cotiza cotiza) {

		_cotizaDao.updateCotiza(cotiza);

	}

	@Override
	public void createCotiza(Cotiza cotiza) {

		_cotizaDao.createCotiza(cotiza);

	}

	@Override
	public void removeCotiza(Long idCotiza) {

		_cotizaDao.removeCotiza(idCotiza);

	}

}
