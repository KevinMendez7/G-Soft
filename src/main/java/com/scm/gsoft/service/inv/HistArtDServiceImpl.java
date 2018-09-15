package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.HistArtDDao;
import com.scm.gsoft.domain.inv.HistArtD;

@Service("HistArtDService")
@Transactional
public class HistArtDServiceImpl implements HistArtDService {

	@Autowired
	private HistArtDDao _histArtDDao;

	@Override
	public List<HistArtD> getHistArtDList(){
		return _histArtDDao.getHistArtDList();
	}

	@Override
	public HistArtD getHistArtDById(Long idHistArtD) {
		// TODO Auto-generated method stub
		return _histArtDDao.getHistArtDById(idHistArtD);
	}

	@Override
	public HistArtD getHistArtDByName(String nameHistArtD) {
		// TODO Auto-generated method stub
		return _histArtDDao.getHistArtDByName(nameHistArtD);
	}

	@Override
	public void updateHistArtD(HistArtD histArtD) {

		_histArtDDao.updateHistArtD(histArtD);

	}

	@Override
	public void createHistArtD(HistArtD histArtD) {

		_histArtDDao.createHistArtD(histArtD);

	}

	@Override
	public void removeHistArtD(Long idHistArtD) {

		_histArtDDao.removeHistArtD(idHistArtD);

	}

}
