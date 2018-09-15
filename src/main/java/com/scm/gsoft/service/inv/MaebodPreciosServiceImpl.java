package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.MaebodPreciosDao;
import com.scm.gsoft.domain.inv.MaebodPrecios;

@Service("MaebodPreciosService")
@Transactional
public class MaebodPreciosServiceImpl implements MaebodPreciosService {

	@Autowired
	private MaebodPreciosDao _maebodPreciosDao;

	@Override
	public List<MaebodPrecios> getMaebodPreciosList(){
		return _maebodPreciosDao.getMaebodPreciosList();
	}

	@Override
	public MaebodPrecios getMaebodPreciosById(Long idMaebodPrecios) {
		// TODO Auto-generated method stub
		return _maebodPreciosDao.getMaebodPreciosById(idMaebodPrecios);
	}

	@Override
	public MaebodPrecios getMaebodPreciosByName(String nameMaebodPrecios) {
		// TODO Auto-generated method stub
		return _maebodPreciosDao.getMaebodPreciosByName(nameMaebodPrecios);
	}

	@Override
	public void updateMaebodPrecios(MaebodPrecios maebodPrecios) {

		_maebodPreciosDao.updateMaebodPrecios(maebodPrecios);

	}

	@Override
	public void createMaebodPrecios(MaebodPrecios maebodPrecios) {

		_maebodPreciosDao.createMaebodPrecios(maebodPrecios);

	}

	@Override
	public void removeMaebodPrecios(Long idMaebodPrecios) {

		_maebodPreciosDao.removeMaebodPrecios(idMaebodPrecios);

	}

}
