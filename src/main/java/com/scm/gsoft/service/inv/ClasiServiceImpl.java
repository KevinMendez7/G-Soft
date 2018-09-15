package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.ClasiDao;
import com.scm.gsoft.domain.inv.Clasi;

@Service("ClasiService")
@Transactional
public class ClasiServiceImpl implements ClasiService {

	@Autowired
	private ClasiDao _clasiDao;

	@Override
	public List<Clasi> getClasiList(){
		return _clasiDao.getClasiList();
	}

	@Override
	public Clasi getClasiById(Long idClasi) {
		// TODO Auto-generated method stub
		return _clasiDao.getClasiById(idClasi);
	}

	@Override
	public Clasi getClasiByName(String nameClasi) {
		// TODO Auto-generated method stub
		return _clasiDao.getClasiByName(nameClasi);
	}

	@Override
	public void updateClasi(Clasi clasi) {

		_clasiDao.updateClasi(clasi);

	}

	@Override
	public void createClasi(Clasi clasi) {

		_clasiDao.createClasi(clasi);

	}

	@Override
	public void removeClasi(Long idClasi) {

		_clasiDao.removeClasi(idClasi);

	}

}
