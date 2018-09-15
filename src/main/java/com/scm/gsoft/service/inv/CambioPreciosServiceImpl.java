package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.CambioPreciosDao;
import com.scm.gsoft.domain.inv.CambioPrecios;

@Service("CambioPreciosService")
@Transactional
public class CambioPreciosServiceImpl implements CambioPreciosService {

	@Autowired
	private CambioPreciosDao _cambioPreciosDao;

	@Override
	public List<CambioPrecios> getCambioPreciosList(){
		return _cambioPreciosDao.getCambioPreciosList();
	}

	@Override
	public CambioPrecios getCambioPreciosById(Long idCambioPrecios) {
		// TODO Auto-generated method stub
		return _cambioPreciosDao.getCambioPreciosById(idCambioPrecios);
	}

	@Override
	public CambioPrecios getCambioPreciosByName(String nameCambioPrecios) {
		// TODO Auto-generated method stub
		return _cambioPreciosDao.getCambioPreciosByName(nameCambioPrecios);
	}

	@Override
	public void updateCambioPrecios(CambioPrecios cambioPrecios) {

		_cambioPreciosDao.updateCambioPrecios(cambioPrecios);

	}

	@Override
	public void createCambioPrecios(CambioPrecios cambioPrecios) {

		_cambioPreciosDao.createCambioPrecios(cambioPrecios);

	}

	@Override
	public void removeCambioPrecios(Long idCambioPrecios) {

		_cambioPreciosDao.removeCambioPrecios(idCambioPrecios);

	}

}
