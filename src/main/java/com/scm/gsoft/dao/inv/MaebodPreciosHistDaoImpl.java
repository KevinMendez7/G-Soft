package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.MaebodPreciosHist;

@Repository
@Transactional
public class MaebodPreciosHistDaoImpl extends AbstractSession implements MaebodPreciosHistDao {

	@Override
	public List<MaebodPreciosHist> getMaebodPreciosHistList(){
		return (List<MaebodPreciosHist>) getCxcSession().createQuery("from MaebodPreciosHist").list();
	}

	@Override
	public MaebodPreciosHist getMaebodPreciosHistById(Long idMaebodPreciosHist) {
		// TODO Auto-generated method stub
		return getCxcSession().get(MaebodPreciosHist.class, idMaebodPreciosHist);
	}

	@Override
	public MaebodPreciosHist getMaebodPreciosHistByName(String nameMaebodPreciosHist) {
		// TODO Auto-generated method stub
		return (MaebodPreciosHist) getCxcSession().createQuery("from MaebodPreciosHist where nombre = :nameMaebodPreciosHist")
				.setParameter("nameMaebodPreciosHist", nameMaebodPreciosHist).uniqueResult();
	}

	@Override
	public void updateMaebodPreciosHist(MaebodPreciosHist maebodPreciosHist) {
		getCxcSession().update(maebodPreciosHist);

	}

	@Override
	public void createMaebodPreciosHist(MaebodPreciosHist maebodPreciosHist) {

		getCxcSession().persist(maebodPreciosHist);

	}

	@Override
	public void removeMaebodPreciosHist(Long idMaebodPreciosHist) {

		MaebodPreciosHist maebodPreciosHist = getMaebodPreciosHistById(idMaebodPreciosHist);
		if(maebodPreciosHist != null) {
			getCxcSession().delete(maebodPreciosHist);
		}

	}

}
