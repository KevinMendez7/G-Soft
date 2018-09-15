package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.DetalleRec;

@Repository
@Transactional
public class DetalleRecDaoImpl extends AbstractSession implements DetalleRecDao {

	@Override
	public List<DetalleRec> getDetalleRecList(){
		return (List<DetalleRec>) getCxcSession().createQuery("from DetalleRec").list();
	}

	@Override
	public DetalleRec getDetalleRecById(Long idDetalleRec) {
		// TODO Auto-generated method stub
		return getCxcSession().get(DetalleRec.class, idDetalleRec);
	}

	@Override
	public DetalleRec getDetalleRecByName(String nameDetalleRec) {
		// TODO Auto-generated method stub
		return (DetalleRec) getCxcSession().createQuery("from DetalleRec where nombre = :nameDetalleRec")
				.setParameter("nameDetalleRec", nameDetalleRec).uniqueResult();
	}

	@Override
	public void updateDetalleRec(DetalleRec detalleRec) {
		getCxcSession().update(detalleRec);

	}

	@Override
	public void createDetalleRec(DetalleRec detalleRec) {

		getCxcSession().persist(detalleRec);

	}

	@Override
	public void removeDetalleRec(Long idDetalleRec) {

		DetalleRec detalleRec = getDetalleRecById(idDetalleRec);
		if(detalleRec != null) {
			getCxcSession().delete(detalleRec);
		}

	}

}
