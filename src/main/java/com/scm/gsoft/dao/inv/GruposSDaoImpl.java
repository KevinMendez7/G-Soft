package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.GruposS;

@Repository
@Transactional
public class GruposSDaoImpl extends AbstractSession implements GruposSDao {

	@Override
	public List<GruposS> getGruposSList(){
		return (List<GruposS>) getCxcSession().createQuery("from GruposS").list();
	}

	@Override
	public GruposS getGruposSById(Long idGruposS) {
		// TODO Auto-generated method stub
		return getCxcSession().get(GruposS.class, idGruposS);
	}

	@Override
	public GruposS getGruposSByName(String nameGruposS) {
		// TODO Auto-generated method stub
		return (GruposS) getCxcSession().createQuery("from GruposS where nombre = :nameGruposS")
				.setParameter("nameGruposS", nameGruposS).uniqueResult();
	}

	@Override
	public void updateGruposS(GruposS gruposS) {
		getCxcSession().update(gruposS);

	}

	@Override
	public void createGruposS(GruposS gruposS) {

		getCxcSession().persist(gruposS);

	}

	@Override
	public void removeGruposS(Long idGruposS) {

		GruposS gruposS = getGruposSById(idGruposS);
		if(gruposS != null) {
			getCxcSession().delete(gruposS);
		}

	}

}
