package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.DetalleFac;

@Repository
@Transactional
public class DetalleFacDaoImpl extends AbstractSession implements DetalleFacDao {

	@Override
	public List<DetalleFac> getDetalleFacList(){
		return (List<DetalleFac>) getCxcSession().createQuery("from DetalleFac").list();
	}

	@Override
	public DetalleFac getDetalleFacById(Long idDetalleFac) {
		// TODO Auto-generated method stub
		return getCxcSession().get(DetalleFac.class, idDetalleFac);
	}

	@Override
	public DetalleFac getDetalleFacByName(String nameDetalleFac) {
		// TODO Auto-generated method stub
		return (DetalleFac) getCxcSession().createQuery("from DetalleFac where nombre = :nameDetalleFac")
				.setParameter("nameDetalleFac", nameDetalleFac).uniqueResult();
	}

	@Override
	public void updateDetalleFac(DetalleFac detalleFac) {
		getCxcSession().update(detalleFac);

	}

	@Override
	public void createDetalleFac(DetalleFac detalleFac) {

		getCxcSession().persist(detalleFac);

	}

	@Override
	public void removeDetalleFac(Long idDetalleFac) {

		DetalleFac detalleFac = getDetalleFacById(idDetalleFac);
		if(detalleFac != null) {
			getCxcSession().delete(detalleFac);
		}

	}

}
