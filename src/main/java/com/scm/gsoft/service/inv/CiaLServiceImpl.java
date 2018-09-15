package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.CiaLDao;
import com.scm.gsoft.domain.inv.CiaL;

@Service("CiaLService")
@Transactional
public class CiaLServiceImpl implements CiaLService {

	@Autowired
	private CiaLDao _ciaLDao;

	@Override
	public List<CiaL> getCiaLList(){
		return _ciaLDao.getCiaLList();
	}

	@Override
	public CiaL getCiaLById(Long idCiaL) {
		// TODO Auto-generated method stub
		return _ciaLDao.getCiaLById(idCiaL);
	}

	@Override
	public CiaL getCiaLByName(String nameCiaL) {
		// TODO Auto-generated method stub
		return _ciaLDao.getCiaLByName(nameCiaL);
	}

	@Override
	public void updateCiaL(CiaL ciaL) {

		_ciaLDao.updateCiaL(ciaL);

	}

	@Override
	public void createCiaL(CiaL ciaL) {

		_ciaLDao.createCiaL(ciaL);

	}

	@Override
	public void removeCiaL(Long idCiaL) {

		_ciaLDao.removeCiaL(idCiaL);

	}

}
