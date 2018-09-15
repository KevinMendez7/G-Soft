package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.ArticuloPadreDao;
import com.scm.gsoft.domain.inv.ArticuloPadre;

@Service("ArticuloPadreService")
@Transactional
public class ArticuloPadreServiceImpl implements ArticuloPadreService {

	@Autowired
	private ArticuloPadreDao _articuloPadreDao;

	@Override
	public List<ArticuloPadre> getArticuloPadreList(){
		return _articuloPadreDao.getArticuloPadreList();
	}

	@Override
	public ArticuloPadre getArticuloPadreById(Long idArticuloPadre) {
		// TODO Auto-generated method stub
		return _articuloPadreDao.getArticuloPadreById(idArticuloPadre);
	}

	@Override
	public ArticuloPadre getArticuloPadreByName(String nameArticuloPadre) {
		// TODO Auto-generated method stub
		return _articuloPadreDao.getArticuloPadreByName(nameArticuloPadre);
	}

	@Override
	public void updateArticuloPadre(ArticuloPadre articuloPadre) {

		_articuloPadreDao.updateArticuloPadre(articuloPadre);

	}

	@Override
	public void createArticuloPadre(ArticuloPadre articuloPadre) {

		_articuloPadreDao.createArticuloPadre(articuloPadre);

	}

	@Override
	public void removeArticuloPadre(Long idArticuloPadre) {

		_articuloPadreDao.removeArticuloPadre(idArticuloPadre);

	}

}
