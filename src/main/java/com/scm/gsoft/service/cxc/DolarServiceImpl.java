package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.DolarDao;
import com.scm.gsoft.domain.cxc.Dolar;

@Qualifier("DolarServiceCxc")
@Service("DolarServiceCxc")
@Transactional
public class DolarServiceImpl implements DolarService {

	@Autowired
	@Qualifier("DolarDaoCxc")
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
