package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.MDetalle;

@Repository
@Transactional
public class MDetalleDaoImpl extends AbstractSession implements MDetalleDao {

	@Override
	public List<MDetalle> getMDetalleList(){
		return (List<MDetalle>) getCxcSession().createQuery("from MDetalle").list();
	}

	@Override
	public MDetalle getMDetalleById(Long idMDetalle) {
		// TODO Auto-generated method stub
		return getCxcSession().get(MDetalle.class, idMDetalle);
	}

	@Override
	public MDetalle getMDetalleByName(String nameMDetalle) {
		// TODO Auto-generated method stub
		return (MDetalle) getCxcSession().createQuery("from MDetalle where nombre = :nameMDetalle")
				.setParameter("nameMDetalle", nameMDetalle).uniqueResult();
	}

	@Override
	public void updateMDetalle(MDetalle mDetalle) {
		getCxcSession().update(mDetalle);

	}

	@Override
	public void createMDetalle(MDetalle mDetalle) {

		getCxcSession().persist(mDetalle);

	}

	@Override
	public void removeMDetalle(Long idMDetalle) {

		MDetalle mDetalle = getMDetalleById(idMDetalle);
		if(mDetalle != null) {
			getCxcSession().delete(mDetalle);
		}

	}

}
