package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.MovD;

@Repository
@Transactional
public class MovDDaoImpl extends AbstractSession implements MovDDao {

	@Override
	public List<MovD> getMovDList(){
		return (List<MovD>) getCxcSession().createQuery("from MovD").list();
	}

	@Override
	public MovD getMovDById(Long idMovD) {
		// TODO Auto-generated method stub
		return getCxcSession().get(MovD.class, idMovD);
	}

	@Override
	public MovD getMovDByName(String nameMovD) {
		// TODO Auto-generated method stub
		return (MovD) getCxcSession().createQuery("from MovD where nombre = :nameMovD")
				.setParameter("nameMovD", nameMovD).uniqueResult();
	}

	@Override
	public void updateMovD(MovD movD) {
		getCxcSession().update(movD);

	}

	@Override
	public void createMovD(MovD movD) {

		getCxcSession().persist(movD);

	}

	@Override
	public void removeMovD(Long idMovD) {

		MovD movD = getMovDById(idMovD);
		if(movD != null) {
			getCxcSession().delete(movD);
		}

	}

}
