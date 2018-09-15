package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.ComprasD;

@Repository
@Transactional
public class ComprasDDaoImpl extends AbstractSession implements ComprasDDao {

	@Override
	public List<ComprasD> getComprasDList(){
		return (List<ComprasD>) getCxcSession().createQuery("from ComprasD").list();
	}

	@Override
	public ComprasD getComprasDById(Long idComprasD) {
		// TODO Auto-generated method stub
		return getCxcSession().get(ComprasD.class, idComprasD);
	}

	@Override
	public ComprasD getComprasDByName(String nameComprasD) {
		// TODO Auto-generated method stub
		return (ComprasD) getCxcSession().createQuery("from ComprasD where nombre = :nameComprasD")
				.setParameter("nameComprasD", nameComprasD).uniqueResult();
	}

	@Override
	public void updateComprasD(ComprasD comprasD) {
		getCxcSession().update(comprasD);

	}

	@Override
	public void createComprasD(ComprasD comprasD) {

		getCxcSession().persist(comprasD);

	}

	@Override
	public void removeComprasD(Long idComprasD) {

		ComprasD comprasD = getComprasDById(idComprasD);
		if(comprasD != null) {
			getCxcSession().delete(comprasD);
		}

	}

}
