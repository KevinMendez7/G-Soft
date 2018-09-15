package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Maestro1;

@Repository
@Transactional
public class Maestro1DaoImpl extends AbstractSession implements Maestro1Dao {

	@Override
	public List<Maestro1> getMaestro1List(){
		return (List<Maestro1>) getCxcSession().createQuery("from Maestro1").list();
	}

	@Override
	public Maestro1 getMaestro1ById(Long idMaestro1) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Maestro1.class, idMaestro1);
	}

	@Override
	public Maestro1 getMaestro1ByName(String nameMaestro1) {
		// TODO Auto-generated method stub
		return (Maestro1) getCxcSession().createQuery("from Maestro1 where nombre = :nameMaestro1")
				.setParameter("nameMaestro1", nameMaestro1).uniqueResult();
	}

	@Override
	public void updateMaestro1(Maestro1 maestro1) {
		getCxcSession().update(maestro1);

	}

	@Override
	public void createMaestro1(Maestro1 maestro1) {

		getCxcSession().persist(maestro1);

	}

	@Override
	public void removeMaestro1(Long idMaestro1) {

		Maestro1 maestro1 = getMaestro1ById(idMaestro1);
		if(maestro1 != null) {
			getCxcSession().delete(maestro1);
		}

	}

}
