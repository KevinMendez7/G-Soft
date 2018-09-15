package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.AniosArtDao;
import com.scm.gsoft.domain.inv.AniosArt;

@Service("AniosArtService")
@Transactional
public class AniosArtServiceImpl implements AniosArtService {

	@Autowired
	private AniosArtDao _aniosArtDao;

	@Override
	public List<AniosArt> getAniosArtList(){
		return _aniosArtDao.getAniosArtList();
	}

	@Override
	public AniosArt getAniosArtById(Long idAniosArt) {
		// TODO Auto-generated method stub
		return _aniosArtDao.getAniosArtById(idAniosArt);
	}

	@Override
	public AniosArt getAniosArtByName(String nameAniosArt) {
		// TODO Auto-generated method stub
		return _aniosArtDao.getAniosArtByName(nameAniosArt);
	}

	@Override
	public void updateAniosArt(AniosArt aniosArt) {

		_aniosArtDao.updateAniosArt(aniosArt);

	}

	@Override
	public void createAniosArt(AniosArt aniosArt) {

		_aniosArtDao.createAniosArt(aniosArt);

	}

	@Override
	public void removeAniosArt(Long idAniosArt) {

		_aniosArtDao.removeAniosArt(idAniosArt);

	}

}
