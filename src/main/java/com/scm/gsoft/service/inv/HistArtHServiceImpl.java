package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.HistArtHDao;
import com.scm.gsoft.domain.inv.HistArtH;

@Service("HistArtHService")
@Transactional
public class HistArtHServiceImpl implements HistArtHService {

	@Autowired
	private HistArtHDao _histArtHDao;

	@Override
	public List<HistArtH> getHistArtHList(){
		return _histArtHDao.getHistArtHList();
	}

	@Override
	public HistArtH getHistArtHById(Long idHistArtH) {
		// TODO Auto-generated method stub
		return _histArtHDao.getHistArtHById(idHistArtH);
	}

	@Override
	public HistArtH getHistArtHByName(String nameHistArtH) {
		// TODO Auto-generated method stub
		return _histArtHDao.getHistArtHByName(nameHistArtH);
	}

	@Override
	public void updateHistArtH(HistArtH histArtH) {

		_histArtHDao.updateHistArtH(histArtH);

	}

	@Override
	public void createHistArtH(HistArtH histArtH) {

		_histArtHDao.createHistArtH(histArtH);

	}

	@Override
	public void removeHistArtH(Long idHistArtH) {

		_histArtHDao.removeHistArtH(idHistArtH);

	}

}
