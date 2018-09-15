package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Maebod;

@Repository
@Transactional
public class MaebodDaoImpl extends AbstractSession implements MaebodDao {

	@Override
	public List<Maebod> getMaebodList(){
		return (List<Maebod>) getCxcSession().createQuery("from Maebod").list();
	}

	@Override
	public Maebod getMaebodById(Long idMaebod) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Maebod.class, idMaebod);
	}

	@Override
	public Maebod getMaebodByName(String nameMaebod) {
		// TODO Auto-generated method stub
		return (Maebod) getCxcSession().createQuery("from Maebod where nombre = :nameMaebod")
				.setParameter("nameMaebod", nameMaebod).uniqueResult();
	}

	@Override
	public void updateMaebod(Maebod maebod) {
		getCxcSession().update(maebod);

	}

	@Override
	public void createMaebod(Maebod maebod) {

		getCxcSession().persist(maebod);

	}

	@Override
	public void removeMaebod(Long idMaebod) {

		Maebod maebod = getMaebodById(idMaebod);
		if(maebod != null) {
			getCxcSession().delete(maebod);
		}

	}

}
