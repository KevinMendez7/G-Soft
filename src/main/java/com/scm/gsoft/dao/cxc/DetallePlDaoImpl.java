package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.DetallePl;

@Repository
@Transactional
public class DetallePlDaoImpl extends AbstractSession implements DetallePlDao {

	@Override
	public List<DetallePl> getDetallePlList(){
		return (List<DetallePl>) getCxcSession().createQuery("from DetallePl").list();
	}

	@Override
	public DetallePl getDetallePlById(Long idDetallePl) {
		// TODO Auto-generated method stub
		return getCxcSession().get(DetallePl.class, idDetallePl);
	}

	@Override
	public DetallePl getDetallePlByName(String nameDetallePl) {
		// TODO Auto-generated method stub
		return (DetallePl) getCxcSession().createQuery("from DetallePl where nombre = :nameDetallePl")
				.setParameter("nameDetallePl", nameDetallePl).uniqueResult();
	}

	@Override
	public void updateDetallePl(DetallePl detallePl) {
		getCxcSession().update(detallePl);

	}

	@Override
	public void createDetallePl(DetallePl detallePl) {

		getCxcSession().persist(detallePl);

	}

	@Override
	public void removeDetallePl(Long idDetallePl) {

		DetallePl detallePl = getDetallePlById(idDetallePl);
		if(detallePl != null) {
			getCxcSession().delete(detallePl);
		}

	}

}
