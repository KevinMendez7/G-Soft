package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.ArtDDao;
import com.scm.gsoft.domain.inv.ArtD;

@Service("ArtDService")
@Transactional
public class ArtDServiceImpl implements ArtDService {

	@Autowired
	private ArtDDao _artDDao;

	@Override
	public List<ArtD> getArtDList(){
		return _artDDao.getArtDList();
	}

	@Override
	public ArtD getArtDById(Long idArtD) {
		// TODO Auto-generated method stub
		return _artDDao.getArtDById(idArtD);
	}

	@Override
	public ArtD getArtDByName(String nameArtD) {
		// TODO Auto-generated method stub
		return _artDDao.getArtDByName(nameArtD);
	}

	@Override
	public void updateArtD(ArtD artD) {

		_artDDao.updateArtD(artD);

	}

	@Override
	public void createArtD(ArtD artD) {

		_artDDao.createArtD(artD);

	}

	@Override
	public void removeArtD(Long idArtD) {

		_artDDao.removeArtD(idArtD);

	}

}
