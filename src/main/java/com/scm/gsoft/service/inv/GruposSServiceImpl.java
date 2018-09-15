package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.GruposSDao;
import com.scm.gsoft.domain.inv.GruposS;

@Service("GruposSService")
@Transactional
public class GruposSServiceImpl implements GruposSService {

	@Autowired
	private GruposSDao _gruposSDao;

	@Override
	public List<GruposS> getGruposSList(){
		return _gruposSDao.getGruposSList();
	}

	@Override
	public GruposS getGruposSById(Long idGruposS) {
		// TODO Auto-generated method stub
		return _gruposSDao.getGruposSById(idGruposS);
	}

	@Override
	public GruposS getGruposSByName(String nameGruposS) {
		// TODO Auto-generated method stub
		return _gruposSDao.getGruposSByName(nameGruposS);
	}

	@Override
	public void updateGruposS(GruposS gruposS) {

		_gruposSDao.updateGruposS(gruposS);

	}

	@Override
	public void createGruposS(GruposS gruposS) {

		_gruposSDao.createGruposS(gruposS);

	}

	@Override
	public void removeGruposS(Long idGruposS) {

		_gruposSDao.removeGruposS(idGruposS);

	}

}
