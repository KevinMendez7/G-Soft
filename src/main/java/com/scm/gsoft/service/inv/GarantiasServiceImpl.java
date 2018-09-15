package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.GarantiasDao;
import com.scm.gsoft.domain.inv.Garantias;

@Service("GarantiasService")
@Transactional
public class GarantiasServiceImpl implements GarantiasService {

	@Autowired
	private GarantiasDao _garantiasDao;

	@Override
	public List<Garantias> getGarantiasList(){
		return _garantiasDao.getGarantiasList();
	}

	@Override
	public Garantias getGarantiasById(Long idGarantias) {
		// TODO Auto-generated method stub
		return _garantiasDao.getGarantiasById(idGarantias);
	}

	@Override
	public Garantias getGarantiasByName(String nameGarantias) {
		// TODO Auto-generated method stub
		return _garantiasDao.getGarantiasByName(nameGarantias);
	}

	@Override
	public void updateGarantias(Garantias garantias) {

		_garantiasDao.updateGarantias(garantias);

	}

	@Override
	public void createGarantias(Garantias garantias) {

		_garantiasDao.createGarantias(garantias);

	}

	@Override
	public void removeGarantias(Long idGarantias) {

		_garantiasDao.removeGarantias(idGarantias);

	}

}
