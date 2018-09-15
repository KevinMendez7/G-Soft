package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.Hoja1SDao;
import com.scm.gsoft.domain.inv.Hoja1S;

@Service("Hoja1SService")
@Transactional
public class Hoja1SServiceImpl implements Hoja1SService {

	@Autowired
	private Hoja1SDao _hoja1SDao;

	@Override
	public List<Hoja1S> getHoja1SList(){
		return _hoja1SDao.getHoja1SList();
	}

	@Override
	public Hoja1S getHoja1SById(Long idHoja1S) {
		// TODO Auto-generated method stub
		return _hoja1SDao.getHoja1SById(idHoja1S);
	}

	@Override
	public Hoja1S getHoja1SByName(String nameHoja1S) {
		// TODO Auto-generated method stub
		return _hoja1SDao.getHoja1SByName(nameHoja1S);
	}

	@Override
	public void updateHoja1S(Hoja1S hoja1S) {

		_hoja1SDao.updateHoja1S(hoja1S);

	}

	@Override
	public void createHoja1S(Hoja1S hoja1S) {

		_hoja1SDao.createHoja1S(hoja1S);

	}

	@Override
	public void removeHoja1S(Long idHoja1S) {

		_hoja1SDao.removeHoja1S(idHoja1S);

	}

}
