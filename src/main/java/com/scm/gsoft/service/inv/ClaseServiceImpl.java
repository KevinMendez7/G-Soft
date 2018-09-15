package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.ClaseDao;
import com.scm.gsoft.domain.inv.Clase;

@Service("ClaseService")
@Transactional
public class ClaseServiceImpl implements ClaseService {

	@Autowired
	private ClaseDao _claseDao;

	@Override
	public List<Clase> getClaseList(){
		return _claseDao.getClaseList();
	}

	@Override
	public Clase getClaseById(Long idClase) {
		// TODO Auto-generated method stub
		return _claseDao.getClaseById(idClase);
	}

	@Override
	public Clase getClaseByName(String nameClase) {
		// TODO Auto-generated method stub
		return _claseDao.getClaseByName(nameClase);
	}

	@Override
	public void updateClase(Clase clase) {

		_claseDao.updateClase(clase);

	}

	@Override
	public void createClase(Clase clase) {

		_claseDao.createClase(clase);

	}

	@Override
	public void removeClase(Long idClase) {

		_claseDao.removeClase(idClase);

	}

}
