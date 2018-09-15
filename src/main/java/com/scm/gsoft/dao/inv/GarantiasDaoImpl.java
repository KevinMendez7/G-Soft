package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Garantias;

@Repository
@Transactional
public class GarantiasDaoImpl extends AbstractSession implements GarantiasDao {

	@Override
	public List<Garantias> getGarantiasList(){
		return (List<Garantias>) getCxcSession().createQuery("from Garantias").list();
	}

	@Override
	public Garantias getGarantiasById(Long idGarantias) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Garantias.class, idGarantias);
	}

	@Override
	public Garantias getGarantiasByName(String nameGarantias) {
		// TODO Auto-generated method stub
		return (Garantias) getCxcSession().createQuery("from Garantias where nombre = :nameGarantias")
				.setParameter("nameGarantias", nameGarantias).uniqueResult();
	}

	@Override
	public void updateGarantias(Garantias garantias) {
		getCxcSession().update(garantias);

	}

	@Override
	public void createGarantias(Garantias garantias) {

		getCxcSession().persist(garantias);

	}

	@Override
	public void removeGarantias(Long idGarantias) {

		Garantias garantias = getGarantiasById(idGarantias);
		if(garantias != null) {
			getCxcSession().delete(garantias);
		}

	}

}
