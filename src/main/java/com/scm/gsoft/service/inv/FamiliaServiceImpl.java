package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.FamiliaDao;
import com.scm.gsoft.domain.inv.Familia;

@Service("FamiliaService")
@Transactional
public class FamiliaServiceImpl implements FamiliaService {

	@Autowired
	private FamiliaDao _familiaDao;

	@Override
	public List<Familia> getFamiliaList(){
		return _familiaDao.getFamiliaList();
	}

	@Override
	public Familia getFamiliaById(Long idFamilia) {
		// TODO Auto-generated method stub
		return _familiaDao.getFamiliaById(idFamilia);
	}

	@Override
	public Familia getFamiliaByName(String nameFamilia) {
		// TODO Auto-generated method stub
		return _familiaDao.getFamiliaByName(nameFamilia);
	}

	@Override
	public void updateFamilia(Familia familia) {

		_familiaDao.updateFamilia(familia);

	}

	@Override
	public void createFamilia(Familia familia) {

		_familiaDao.createFamilia(familia);

	}

	@Override
	public void removeFamilia(Long idFamilia) {

		_familiaDao.removeFamilia(idFamilia);

	}

}
