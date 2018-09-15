package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.MaestroIms;

@Repository
@Transactional
public class MaestroImsDaoImpl extends AbstractSession implements MaestroImsDao {

	@Override
	public List<MaestroIms> getMaestroImsList(){
		return (List<MaestroIms>) getCxcSession().createQuery("from MaestroIms").list();
	}

	@Override
	public MaestroIms getMaestroImsById(Long idMaestroIms) {
		// TODO Auto-generated method stub
		return getCxcSession().get(MaestroIms.class, idMaestroIms);
	}

	@Override
	public MaestroIms getMaestroImsByName(String nameMaestroIms) {
		// TODO Auto-generated method stub
		return (MaestroIms) getCxcSession().createQuery("from MaestroIms where nombre = :nameMaestroIms")
				.setParameter("nameMaestroIms", nameMaestroIms).uniqueResult();
	}

	@Override
	public void updateMaestroIms(MaestroIms maestroIms) {
		getCxcSession().update(maestroIms);

	}

	@Override
	public void createMaestroIms(MaestroIms maestroIms) {

		getCxcSession().persist(maestroIms);

	}

	@Override
	public void removeMaestroIms(Long idMaestroIms) {

		MaestroIms maestroIms = getMaestroImsById(idMaestroIms);
		if(maestroIms != null) {
			getCxcSession().delete(maestroIms);
		}

	}

}
