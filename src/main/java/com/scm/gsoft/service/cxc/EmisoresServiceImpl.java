package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.EmisoresDao;
import com.scm.gsoft.domain.cxc.Emisores;

@Service("EmisoresService")
@Transactional
public class EmisoresServiceImpl implements EmisoresService {

	@Autowired
	private EmisoresDao _emisoresDao;

	@Override
	public List<Emisores> getEmisoresList(){
		return _emisoresDao.getEmisoresList();
	}

	@Override
	public Emisores getEmisoresById(Long idEmisores) {
		// TODO Auto-generated method stub
		return _emisoresDao.getEmisoresById(idEmisores);
	}

	@Override
	public Emisores getEmisoresByName(String nameEmisores) {
		// TODO Auto-generated method stub
		return _emisoresDao.getEmisoresByName(nameEmisores);
	}

	@Override
	public void updateEmisores(Emisores emisores) {

		_emisoresDao.updateEmisores(emisores);

	}

	@Override
	public void createEmisores(Emisores emisores) {

		_emisoresDao.createEmisores(emisores);

	}

	@Override
	public void removeEmisores(Long idEmisores) {

		_emisoresDao.removeEmisores(idEmisores);

	}

}
