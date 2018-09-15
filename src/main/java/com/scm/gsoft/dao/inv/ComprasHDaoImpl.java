package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.ComprasH;

@Repository
@Transactional
public class ComprasHDaoImpl extends AbstractSession implements ComprasHDao {

	@Override
	public List<ComprasH> getComprasHList(){
		return (List<ComprasH>) getCxcSession().createQuery("from ComprasH").list();
	}

	@Override
	public ComprasH getComprasHById(Long idComprasH) {
		// TODO Auto-generated method stub
		return getCxcSession().get(ComprasH.class, idComprasH);
	}

	@Override
	public ComprasH getComprasHByName(String nameComprasH) {
		// TODO Auto-generated method stub
		return (ComprasH) getCxcSession().createQuery("from ComprasH where nombre = :nameComprasH")
				.setParameter("nameComprasH", nameComprasH).uniqueResult();
	}

	@Override
	public void updateComprasH(ComprasH comprasH) {
		getCxcSession().update(comprasH);

	}

	@Override
	public void createComprasH(ComprasH comprasH) {

		getCxcSession().persist(comprasH);

	}

	@Override
	public void removeComprasH(Long idComprasH) {

		ComprasH comprasH = getComprasHById(idComprasH);
		if(comprasH != null) {
			getCxcSession().delete(comprasH);
		}

	}

}
