package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.UnidadDao;
import com.scm.gsoft.domain.inv.Unidad;

@Service("UnidadService")
@Transactional
public class UnidadServiceImpl implements UnidadService {

	@Autowired
	private UnidadDao _unidadDao;

	@Override
	public List<Unidad> getUnidadList(){
		return _unidadDao.getUnidadList();
	}

	@Override
	public Unidad getUnidadById(Long idUnidad) {
		// TODO Auto-generated method stub
		return _unidadDao.getUnidadById(idUnidad);
	}

	@Override
	public Unidad getUnidadByName(String nameUnidad) {
		// TODO Auto-generated method stub
		return _unidadDao.getUnidadByName(nameUnidad);
	}

	@Override
	public void updateUnidad(Unidad unidad) {

		_unidadDao.updateUnidad(unidad);

	}

	@Override
	public void createUnidad(Unidad unidad) {

		_unidadDao.createUnidad(unidad);

	}

	@Override
	public void removeUnidad(Long idUnidad) {

		_unidadDao.removeUnidad(idUnidad);

	}

}
