package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.SimilaridadDao;
import com.scm.gsoft.domain.inv.Similaridad;

@Service("SimilaridadService")
@Transactional
public class SimilaridadServiceImpl implements SimilaridadService {

	@Autowired
	private SimilaridadDao _similaridadDao;

	@Override
	public List<Similaridad> getSimilaridadList(){
		return _similaridadDao.getSimilaridadList();
	}

	@Override
	public Similaridad getSimilaridadById(Long idSimilaridad) {
		// TODO Auto-generated method stub
		return _similaridadDao.getSimilaridadById(idSimilaridad);
	}

	@Override
	public Similaridad getSimilaridadByName(String nameSimilaridad) {
		// TODO Auto-generated method stub
		return _similaridadDao.getSimilaridadByName(nameSimilaridad);
	}

	@Override
	public void updateSimilaridad(Similaridad similaridad) {

		_similaridadDao.updateSimilaridad(similaridad);

	}

	@Override
	public void createSimilaridad(Similaridad similaridad) {

		_similaridadDao.createSimilaridad(similaridad);

	}

	@Override
	public void removeSimilaridad(Long idSimilaridad) {

		_similaridadDao.removeSimilaridad(idSimilaridad);

	}

}
