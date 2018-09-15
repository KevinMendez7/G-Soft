package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.ProveeDao;
import com.scm.gsoft.domain.inv.Provee;

@Service("ProveeService")
@Transactional
public class ProveeServiceImpl implements ProveeService {

	@Autowired
	private ProveeDao _proveeDao;

	@Override
	public List<Provee> getProveeList(){
		return _proveeDao.getProveeList();
	}

	@Override
	public Provee getProveeById(Long idProvee) {
		// TODO Auto-generated method stub
		return _proveeDao.getProveeById(idProvee);
	}

	@Override
	public Provee getProveeByName(String nameProvee) {
		// TODO Auto-generated method stub
		return _proveeDao.getProveeByName(nameProvee);
	}

	@Override
	public void updateProvee(Provee provee) {

		_proveeDao.updateProvee(provee);

	}

	@Override
	public void createProvee(Provee provee) {

		_proveeDao.createProvee(provee);

	}

	@Override
	public void removeProvee(Long idProvee) {

		_proveeDao.removeProvee(idProvee);

	}

}
