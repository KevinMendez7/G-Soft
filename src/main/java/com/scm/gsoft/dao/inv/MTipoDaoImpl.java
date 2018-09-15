package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.MTipo;

@Repository
@Transactional
public class MTipoDaoImpl extends AbstractSession implements MTipoDao {

	@Override
	public List<MTipo> getMTipoList(){
		return (List<MTipo>) getCxcSession().createQuery("from MTipo").list();
	}

	@Override
	public MTipo getMTipoById(Long idMTipo) {
		// TODO Auto-generated method stub
		return getCxcSession().get(MTipo.class, idMTipo);
	}

	@Override
	public MTipo getMTipoByName(String nameMTipo) {
		// TODO Auto-generated method stub
		return (MTipo) getCxcSession().createQuery("from MTipo where nombre = :nameMTipo")
				.setParameter("nameMTipo", nameMTipo).uniqueResult();
	}

	@Override
	public void updateMTipo(MTipo mTipo) {
		getCxcSession().update(mTipo);

	}

	@Override
	public void createMTipo(MTipo mTipo) {

		getCxcSession().persist(mTipo);

	}

	@Override
	public void removeMTipo(Long idMTipo) {

		MTipo mTipo = getMTipoById(idMTipo);
		if(mTipo != null) {
			getCxcSession().delete(mTipo);
		}

	}

}
