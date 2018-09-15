package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.ArtHDao;
import com.scm.gsoft.domain.inv.ArtH;

@Service("ArtHService")
@Transactional
public class ArtHServiceImpl implements ArtHService {

	@Autowired
	private ArtHDao _artHDao;

	@Override
	public List<ArtH> getArtHList(){
		return _artHDao.getArtHList();
	}

	@Override
	public ArtH getArtHById(Long idArtH) {
		// TODO Auto-generated method stub
		return _artHDao.getArtHById(idArtH);
	}

	@Override
	public ArtH getArtHByName(String nameArtH) {
		// TODO Auto-generated method stub
		return _artHDao.getArtHByName(nameArtH);
	}

	@Override
	public void updateArtH(ArtH artH) {

		_artHDao.updateArtH(artH);

	}

	@Override
	public void createArtH(ArtH artH) {

		_artHDao.createArtH(artH);

	}

	@Override
	public void removeArtH(Long idArtH) {

		_artHDao.removeArtH(idArtH);

	}

}
