package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.BodegaDao;
import com.scm.gsoft.domain.cxc.Bodega;

@Qualifier("BodegaServiceCxc")
@Service("BodegaServiceCxc")
@Transactional
public class BodegaServiceImpl implements BodegaService {

	@Autowired
	@Qualifier("BodegaDaoCxc")
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
	public Bodega getBodegaByCode(String codeBodega) {
		// TODO Auto-generated method stub
		return _bodegaDao.getBodegaByCode(codeBodega);
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
