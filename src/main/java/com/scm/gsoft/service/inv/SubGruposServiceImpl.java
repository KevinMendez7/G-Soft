package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.SubGruposDao;
import com.scm.gsoft.domain.inv.SubGrupos;

@Service("SubGruposService")
@Transactional
public class SubGruposServiceImpl implements SubGruposService {

	@Autowired
	private SubGruposDao _subGruposDao;

	@Override
	public List<SubGrupos> getSubGruposList(){
		return _subGruposDao.getSubGruposList();
	}

	@Override
	public SubGrupos getSubGruposById(Long idSubGrupos) {
		// TODO Auto-generated method stub
		return _subGruposDao.getSubGruposById(idSubGrupos);
	}

	@Override
	public SubGrupos getSubGruposByName(String nameSubGrupos) {
		// TODO Auto-generated method stub
		return _subGruposDao.getSubGruposByName(nameSubGrupos);
	}

	@Override
	public void updateSubGrupos(SubGrupos subGrupos) {

		_subGruposDao.updateSubGrupos(subGrupos);

	}

	@Override
	public void createSubGrupos(SubGrupos subGrupos) {

		_subGruposDao.createSubGrupos(subGrupos);

	}

	@Override
	public void removeSubGrupos(Long idSubGrupos) {

		_subGruposDao.removeSubGrupos(idSubGrupos);

	}

}
