package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.MovDDao;
import com.scm.gsoft.domain.inv.MovD;

@Service("MovDService")
@Transactional
public class MovDServiceImpl implements MovDService {

	@Autowired
	private MovDDao _movDDao;

	@Override
	public List<MovD> getMovDList(){
		return _movDDao.getMovDList();
	}

	@Override
	public MovD getMovDById(Long idMovD) {
		// TODO Auto-generated method stub
		return _movDDao.getMovDById(idMovD);
	}

	@Override
	public MovD getMovDByName(String nameMovD) {
		// TODO Auto-generated method stub
		return _movDDao.getMovDByName(nameMovD);
	}

	@Override
	public void updateMovD(MovD movD) {

		_movDDao.updateMovD(movD);

	}

	@Override
	public void createMovD(MovD movD) {

		_movDDao.createMovD(movD);

	}

	@Override
	public void removeMovD(Long idMovD) {

		_movDDao.removeMovD(idMovD);

	}

}
