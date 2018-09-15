package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.CalidadDao;
import com.scm.gsoft.domain.inv.Calidad;

@Service("CalidadService")
@Transactional
public class CalidadServiceImpl implements CalidadService {

	@Autowired
	private CalidadDao _calidadDao;

	@Override
	public List<Calidad> getCalidadList(){
		return _calidadDao.getCalidadList();
	}

	@Override
	public Calidad getCalidadById(Long idCalidad) {
		// TODO Auto-generated method stub
		return _calidadDao.getCalidadById(idCalidad);
	}

	@Override
	public Calidad getCalidadByName(String nameCalidad) {
		// TODO Auto-generated method stub
		return _calidadDao.getCalidadByName(nameCalidad);
	}

	@Override
	public void updateCalidad(Calidad calidad) {

		_calidadDao.updateCalidad(calidad);

	}

	@Override
	public void createCalidad(Calidad calidad) {

		_calidadDao.createCalidad(calidad);

	}

	@Override
	public void removeCalidad(Long idCalidad) {

		_calidadDao.removeCalidad(idCalidad);

	}

}
