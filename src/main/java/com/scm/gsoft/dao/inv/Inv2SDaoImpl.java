package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Inv2S;

@Repository
@Transactional
public class Inv2SDaoImpl extends AbstractSession implements Inv2SDao {

	@Override
	public List<Inv2S> getInv2SList(){
		return (List<Inv2S>) getCxcSession().createQuery("from Inv2S").list();
	}

	@Override
	public Inv2S getInv2SById(Long idInv2S) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Inv2S.class, idInv2S);
	}

	@Override
	public Inv2S getInv2SByName(String nameInv2S) {
		// TODO Auto-generated method stub
		return (Inv2S) getCxcSession().createQuery("from Inv2S where nombre = :nameInv2S")
				.setParameter("nameInv2S", nameInv2S).uniqueResult();
	}

	@Override
	public void updateInv2S(Inv2S inv2S) {
		getCxcSession().update(inv2S);

	}

	@Override
	public void createInv2S(Inv2S inv2S) {

		getCxcSession().persist(inv2S);

	}

	@Override
	public void removeInv2S(Long idInv2S) {

		Inv2S inv2S = getInv2SById(idInv2S);
		if(inv2S != null) {
			getCxcSession().delete(inv2S);
		}

	}

}
