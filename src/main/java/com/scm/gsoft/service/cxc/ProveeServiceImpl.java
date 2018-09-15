package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.ProveeDao;
import com.scm.gsoft.domain.cxc.Provee;

@Qualifier("ProveeServiceCxc")
@Service("ProveeServiceCxc")
@Transactional
public class ProveeServiceImpl implements ProveeService {

	@Autowired
	@Qualifier("ProveeDaoCxc")
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
