package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.GruposDao;
import com.scm.gsoft.domain.inv.Grupos;

@Service("GruposService")
@Transactional
public class GruposServiceImpl implements GruposService {

	@Autowired
	private GruposDao _gruposDao;

	@Override
	public List<Grupos> getGruposList(){
		return _gruposDao.getGruposList();
	}

	@Override
	public Grupos getGruposById(Long idGrupos) {
		// TODO Auto-generated method stub
		return _gruposDao.getGruposById(idGrupos);
	}

	@Override
	public Grupos getGruposByName(String nameGrupos) {
		// TODO Auto-generated method stub
		return _gruposDao.getGruposByName(nameGrupos);
	}

	@Override
	public void updateGrupos(Grupos grupos) {

		_gruposDao.updateGrupos(grupos);

	}

	@Override
	public void createGrupos(Grupos grupos) {

		_gruposDao.createGrupos(grupos);

	}

	@Override
	public void removeGrupos(Long idGrupos) {

		_gruposDao.removeGrupos(idGrupos);

	}

}
