package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.CotizaDDao;
import com.scm.gsoft.domain.cxc.CotizaD;

@Service("CotizaDService")
@Transactional
public class CotizaDServiceImpl implements CotizaDService {

	@Autowired
	private CotizaDDao _cotizaDDao;

	@Override
	public List<CotizaD> getCotizaDList(){
		return _cotizaDDao.getCotizaDList();
	}

	@Override
	public CotizaD getCotizaDById(Long idCotizaD) {
		// TODO Auto-generated method stub
		return _cotizaDDao.getCotizaDById(idCotizaD);
	}

	@Override
	public CotizaD getCotizaDByName(String nameCotizaD) {
		// TODO Auto-generated method stub
		return _cotizaDDao.getCotizaDByName(nameCotizaD);
	}

	@Override
	public void updateCotizaD(CotizaD cotizaD) {

		_cotizaDDao.updateCotizaD(cotizaD);

	}

	@Override
	public void createCotizaD(CotizaD cotizaD) {

		_cotizaDDao.createCotizaD(cotizaD);

	}

	@Override
	public void removeCotizaD(Long idCotizaD) {

		_cotizaDDao.removeCotizaD(idCotizaD);

	}

}
