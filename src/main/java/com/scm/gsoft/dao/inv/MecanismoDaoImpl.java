package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Mecanismo;

@Repository
@Transactional
public class MecanismoDaoImpl extends AbstractSession implements MecanismoDao {

	@Override
	public List<Mecanismo> getMecanismoList(){
		return (List<Mecanismo>) getCxcSession().createQuery("from Mecanismo").list();
	}

	@Override
	public Mecanismo getMecanismoById(Long idMecanismo) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Mecanismo.class, idMecanismo);
	}

	@Override
	public Mecanismo getMecanismoByName(String nameMecanismo) {
		// TODO Auto-generated method stub
		return (Mecanismo) getCxcSession().createQuery("from Mecanismo where nombre = :nameMecanismo")
				.setParameter("nameMecanismo", nameMecanismo).uniqueResult();
	}

	@Override
	public void updateMecanismo(Mecanismo mecanismo) {
		getCxcSession().update(mecanismo);

	}

	@Override
	public void createMecanismo(Mecanismo mecanismo) {

		getCxcSession().persist(mecanismo);

	}

	@Override
	public void removeMecanismo(Long idMecanismo) {

		Mecanismo mecanismo = getMecanismoById(idMecanismo);
		if(mecanismo != null) {
			getCxcSession().delete(mecanismo);
		}

	}

}
