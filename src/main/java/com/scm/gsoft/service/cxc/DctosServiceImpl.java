package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.DctosDao;
import com.scm.gsoft.domain.cxc.Dctos;

@Service("DctosService")
@Transactional
public class DctosServiceImpl implements DctosService {

	@Autowired
	private DctosDao _dctosDao;

	@Override
	public List<Dctos> getDctosList(){
		return _dctosDao.getDctosList();
	}

	@Override
	public Dctos getDctosById(Long idDctos) {
		// TODO Auto-generated method stub
		return _dctosDao.getDctosById(idDctos);
	}

	@Override
	public Dctos getDctosByName(String nameDctos) {
		// TODO Auto-generated method stub
		return _dctosDao.getDctosByName(nameDctos);
	}

	@Override
	public void updateDctos(Dctos dctos) {

		_dctosDao.updateDctos(dctos);

	}

	@Override
	public void createDctos(Dctos dctos) {

		_dctosDao.createDctos(dctos);

	}

	@Override
	public void removeDctos(Long idDctos) {

		_dctosDao.removeDctos(idDctos);

	}

}
