package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.CabezaPDao;
import com.scm.gsoft.domain.cxc.CabezaP;

@Service("CabezaPService")
@Transactional
public class CabezaPServiceImpl implements CabezaPService {

	@Autowired
	private CabezaPDao _cabezaPDao;

	@Override
	public List<CabezaP> getCabezaPList(){
		return _cabezaPDao.getCabezaPList();
	}

	@Override
	public CabezaP getCabezaPById(Long idCabezaP) {
		// TODO Auto-generated method stub
		return _cabezaPDao.getCabezaPById(idCabezaP);
	}

	@Override
	public CabezaP getCabezaPByName(String nameCabezaP) {
		// TODO Auto-generated method stub
		return _cabezaPDao.getCabezaPByName(nameCabezaP);
	}

	@Override
	public void updateCabezaP(CabezaP cabezaP) {

		_cabezaPDao.updateCabezaP(cabezaP);

	}

	@Override
	public void createCabezaP(CabezaP cabezaP) {

		_cabezaPDao.createCabezaP(cabezaP);

	}

	@Override
	public void removeCabezaP(Long idCabezaP) {

		_cabezaPDao.removeCabezaP(idCabezaP);

	}

}
