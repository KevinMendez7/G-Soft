package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.ControlCierre;

@Repository
@Transactional
public class ControlCierreDaoImpl extends AbstractSession implements ControlCierreDao {

	@Override
	public List<ControlCierre> getControlCierreList(){
		return (List<ControlCierre>) getCxcSession().createQuery("from ControlCierre").list();
	}

	@Override
	public ControlCierre getControlCierreById(Long idControlCierre) {
		// TODO Auto-generated method stub
		return getCxcSession().get(ControlCierre.class, idControlCierre);
	}

	@Override
	public ControlCierre getControlCierreByName(String nameControlCierre) {
		// TODO Auto-generated method stub
		return (ControlCierre) getCxcSession().createQuery("from ControlCierre where nombre = :nameControlCierre")
				.setParameter("nameControlCierre", nameControlCierre).uniqueResult();
	}

	@Override
	public void updateControlCierre(ControlCierre controlCierre) {
		getCxcSession().update(controlCierre);

	}

	@Override
	public void createControlCierre(ControlCierre controlCierre) {

		getCxcSession().persist(controlCierre);

	}

	@Override
	public void removeControlCierre(Long idControlCierre) {

		ControlCierre controlCierre = getControlCierreById(idControlCierre);
		if(controlCierre != null) {
			getCxcSession().delete(controlCierre);
		}

	}

}
