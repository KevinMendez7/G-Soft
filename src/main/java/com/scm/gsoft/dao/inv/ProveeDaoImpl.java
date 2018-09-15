package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Provee;

@Repository
@Transactional
public class ProveeDaoImpl extends AbstractSession implements ProveeDao {

	@Override
	public List<Provee> getProveeList(){
		return (List<Provee>) getCxcSession().createQuery("from Provee").list();
	}

	@Override
	public Provee getProveeById(Long idProvee) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Provee.class, idProvee);
	}

	@Override
	public Provee getProveeByName(String nameProvee) {
		// TODO Auto-generated method stub
		return (Provee) getCxcSession().createQuery("from Provee where nombre = :nameProvee")
				.setParameter("nameProvee", nameProvee).uniqueResult();
	}

	@Override
	public void updateProvee(Provee provee) {
		getCxcSession().update(provee);

	}

	@Override
	public void createProvee(Provee provee) {

		getCxcSession().persist(provee);

	}

	@Override
	public void removeProvee(Long idProvee) {

		Provee provee = getProveeById(idProvee);
		if(provee != null) {
			getCxcSession().delete(provee);
		}

	}

}
