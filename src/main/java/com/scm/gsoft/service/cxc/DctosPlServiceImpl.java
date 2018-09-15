package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.DctosPlDao;
import com.scm.gsoft.domain.cxc.DctosPl;

@Service("DctosPlService")
@Transactional
public class DctosPlServiceImpl implements DctosPlService {

	@Autowired
	private DctosPlDao _dctosPlDao;

	@Override
	public List<DctosPl> getDctosPlList(){
		return _dctosPlDao.getDctosPlList();
	}

	@Override
	public DctosPl getDctosPlById(Long idDctosPl) {
		// TODO Auto-generated method stub
		return _dctosPlDao.getDctosPlById(idDctosPl);
	}

	@Override
	public DctosPl getDctosPlByName(String nameDctosPl) {
		// TODO Auto-generated method stub
		return _dctosPlDao.getDctosPlByName(nameDctosPl);
	}

	@Override
	public void updateDctosPl(DctosPl dctosPl) {

		_dctosPlDao.updateDctosPl(dctosPl);

	}

	@Override
	public void createDctosPl(DctosPl dctosPl) {

		_dctosPlDao.createDctosPl(dctosPl);

	}

	@Override
	public void removeDctosPl(Long idDctosPl) {

		_dctosPlDao.removeDctosPl(idDctosPl);

	}

}
