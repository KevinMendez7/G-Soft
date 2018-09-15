package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Detalle;

@Repository
@Transactional
public class DetalleDaoImpl extends AbstractSession implements DetalleDao {

	@Override
	public List<Detalle> getDetalleList(){
		return (List<Detalle>) getCxcSession().createQuery("from Detalle").list();
	}

	@Override
	public Detalle getDetalleById(Long idDetalle) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Detalle.class, idDetalle);
	}

	@Override
	public Detalle getDetalleByName(String nameDetalle) {
		// TODO Auto-generated method stub
		return (Detalle) getCxcSession().createQuery("from Detalle where nombre = :nameDetalle")
				.setParameter("nameDetalle", nameDetalle).uniqueResult();
	}

	@Override
	public void updateDetalle(Detalle detalle) {
		getCxcSession().update(detalle);

	}

	@Override
	public void createDetalle(Detalle detalle) {

		getCxcSession().persist(detalle);

	}

	@Override
	public void removeDetalle(Long idDetalle) {

		Detalle detalle = getDetalleById(idDetalle);
		if(detalle != null) {
			getCxcSession().delete(detalle);
		}

	}

}
