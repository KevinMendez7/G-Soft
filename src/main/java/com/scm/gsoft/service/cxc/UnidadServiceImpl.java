package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.UnidadDao;
import com.scm.gsoft.domain.cxc.Unidad;

@Qualifier("UnidadServiceCxc")
@Service("UnidadServiceCxc")
@Transactional
public class UnidadServiceImpl implements UnidadService {

	@Autowired
	@Qualifier("UnidadDaoCxc")
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
