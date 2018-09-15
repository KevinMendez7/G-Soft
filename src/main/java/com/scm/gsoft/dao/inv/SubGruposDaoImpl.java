package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.SubGrupos;

@Repository
@Transactional
public class SubGruposDaoImpl extends AbstractSession implements SubGruposDao {

	@Override
	public List<SubGrupos> getSubGruposList(){
		return (List<SubGrupos>) getCxcSession().createQuery("from SubGrupos").list();
	}

	@Override
	public SubGrupos getSubGruposById(Long idSubGrupos) {
		// TODO Auto-generated method stub
		return getCxcSession().get(SubGrupos.class, idSubGrupos);
	}

	@Override
	public SubGrupos getSubGruposByName(String nameSubGrupos) {
		// TODO Auto-generated method stub
		return (SubGrupos) getCxcSession().createQuery("from SubGrupos where nombre = :nameSubGrupos")
				.setParameter("nameSubGrupos", nameSubGrupos).uniqueResult();
	}

	@Override
	public void updateSubGrupos(SubGrupos subGrupos) {
		getCxcSession().update(subGrupos);

	}

	@Override
	public void createSubGrupos(SubGrupos subGrupos) {

		getCxcSession().persist(subGrupos);

	}

	@Override
	public void removeSubGrupos(Long idSubGrupos) {

		SubGrupos subGrupos = getSubGruposById(idSubGrupos);
		if(subGrupos != null) {
			getCxcSession().delete(subGrupos);
		}

	}

}
