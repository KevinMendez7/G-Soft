package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.CiaLDao;
import com.scm.gsoft.domain.cxc.CiaL;

@Qualifier("CiaLServiceCxc")
@Service("CiaLServiceCxc")
@Transactional
public class CiaLServiceImpl implements CiaLService {

	@Autowired
	@Qualifier("CiaLDaoCxc")
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
