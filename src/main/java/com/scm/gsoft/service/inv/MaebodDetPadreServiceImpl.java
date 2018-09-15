package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.MaebodDetPadreDao;
import com.scm.gsoft.domain.inv.MaebodDetPadre;

@Service("MaebodDetPadreService")
@Transactional
public class MaebodDetPadreServiceImpl implements MaebodDetPadreService {

	@Autowired
	private MaebodDetPadreDao _maebodDetPadreDao;

	@Override
	public List<MaebodDetPadre> getMaebodDetPadreList(){
		return _maebodDetPadreDao.getMaebodDetPadreList();
	}

	@Override
	public MaebodDetPadre getMaebodDetPadreById(Long idMaebodDetPadre) {
		// TODO Auto-generated method stub
		return _maebodDetPadreDao.getMaebodDetPadreById(idMaebodDetPadre);
	}

	@Override
	public MaebodDetPadre getMaebodDetPadreByName(String nameMaebodDetPadre) {
		// TODO Auto-generated method stub
		return _maebodDetPadreDao.getMaebodDetPadreByName(nameMaebodDetPadre);
	}

	@Override
	public void updateMaebodDetPadre(MaebodDetPadre maebodDetPadre) {

		_maebodDetPadreDao.updateMaebodDetPadre(maebodDetPadre);

	}

	@Override
	public void createMaebodDetPadre(MaebodDetPadre maebodDetPadre) {

		_maebodDetPadreDao.createMaebodDetPadre(maebodDetPadre);

	}

	@Override
	public void removeMaebodDetPadre(Long idMaebodDetPadre) {

		_maebodDetPadreDao.removeMaebodDetPadre(idMaebodDetPadre);

	}

}
