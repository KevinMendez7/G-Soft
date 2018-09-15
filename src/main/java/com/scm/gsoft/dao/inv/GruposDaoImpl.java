package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Grupos;

@Repository
@Transactional
public class GruposDaoImpl extends AbstractSession implements GruposDao {

	@Override
	public List<Grupos> getGruposList(){
		return (List<Grupos>) getCxcSession().createQuery("from Grupos").list();
	}

	@Override
	public Grupos getGruposById(Long idGrupos) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Grupos.class, idGrupos);
	}

	@Override
	public Grupos getGruposByName(String nameGrupos) {
		// TODO Auto-generated method stub
		return (Grupos) getCxcSession().createQuery("from Grupos where nombre = :nameGrupos")
				.setParameter("nameGrupos", nameGrupos).uniqueResult();
	}

	@Override
	public void updateGrupos(Grupos grupos) {
		getCxcSession().update(grupos);

	}

	@Override
	public void createGrupos(Grupos grupos) {

		getCxcSession().persist(grupos);

	}

	@Override
	public void removeGrupos(Long idGrupos) {

		Grupos grupos = getGruposById(idGrupos);
		if(grupos != null) {
			getCxcSession().delete(grupos);
		}

	}

}
