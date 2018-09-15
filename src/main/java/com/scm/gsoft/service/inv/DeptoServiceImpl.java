package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.DeptoDao;
import com.scm.gsoft.domain.inv.Depto;

@Service("DeptoService")
@Transactional
public class DeptoServiceImpl implements DeptoService {

	@Autowired
	private DeptoDao _deptoDao;

	@Override
	public List<Depto> getDeptoList(){
		return _deptoDao.getDeptoList();
	}

	@Override
	public Depto getDeptoById(Long idDepto) {
		// TODO Auto-generated method stub
		return _deptoDao.getDeptoById(idDepto);
	}

	@Override
	public Depto getDeptoByName(String nameDepto) {
		// TODO Auto-generated method stub
		return _deptoDao.getDeptoByName(nameDepto);
	}

	@Override
	public void updateDepto(Depto depto) {

		_deptoDao.updateDepto(depto);

	}

	@Override
	public void createDepto(Depto depto) {

		_deptoDao.createDepto(depto);

	}

	@Override
	public void removeDepto(Long idDepto) {

		_deptoDao.removeDepto(idDepto);

	}

}
