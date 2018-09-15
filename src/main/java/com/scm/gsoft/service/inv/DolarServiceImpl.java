package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.DolarDao;
import com.scm.gsoft.domain.inv.Dolar;

@Service("DolarService")
@Transactional
public class DolarServiceImpl implements DolarService {

	@Autowired
	private DolarDao _dolarDao;

	@Override
	public List<Dolar> getDolarList(){
		return _dolarDao.getDolarList();
	}

	@Override
	public Dolar getDolarById(Long idDolar) {
		// TODO Auto-generated method stub
		return _dolarDao.getDolarById(idDolar);
	}

	@Override
	public Dolar getDolarByName(String nameDolar) {
		// TODO Auto-generated method stub
		return _dolarDao.getDolarByName(nameDolar);
	}

	@Override
	public void updateDolar(Dolar dolar) {

		_dolarDao.updateDolar(dolar);

	}

	@Override
	public void createDolar(Dolar dolar) {

		_dolarDao.createDolar(dolar);

	}

	@Override
	public void removeDolar(Long idDolar) {

		_dolarDao.removeDolar(idDolar);

	}

}
