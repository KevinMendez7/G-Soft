package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.ClaseDao;
import com.scm.gsoft.domain.cxc.Clase;

@Qualifier("ClaseServiceCxc")
@Service("ClaseServiceCxc")
@Transactional
public class ClaseServiceImpl implements ClaseService {

	@Autowired
	@Qualifier("ClaseDaoCxc")
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
