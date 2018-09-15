package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.BodegaDao;
import com.scm.gsoft.domain.inv.Bodega;

@Service("BodegaService")
@Transactional
public class BodegaServiceImpl implements BodegaService {

	@Autowired
	private BodegaDao _bodegaDao;

	@Override
	public List<Bodega> getBodegaList(){
		return _bodegaDao.getBodegaList();
	}

	@Override
	public Bodega getBodegaById(Long idBodega) {
		// TODO Auto-generated method stub
		return _bodegaDao.getBodegaById(idBodega);
	}

	@Override
	public Bodega getBodegaByName(String nameBodega) {
		// TODO Auto-generated method stub
		return _bodegaDao.getBodegaByName(nameBodega);
	}

	@Override
	public void updateBodega(Bodega bodega) {

		_bodegaDao.updateBodega(bodega);

	}

	@Override
	public void createBodega(Bodega bodega) {

		_bodegaDao.createBodega(bodega);

	}

	@Override
	public void removeBodega(Long idBodega) {

		_bodegaDao.removeBodega(idBodega);

	}

}
