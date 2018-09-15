package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.MaebodDet;

@Repository
@Transactional
public class MaebodDetDaoImpl extends AbstractSession implements MaebodDetDao {

	@Override
	public List<MaebodDet> getMaebodDetList(){
		return (List<MaebodDet>) getCxcSession().createQuery("from MaebodDet").list();
	}

	@Override
	public MaebodDet getMaebodDetById(Long idMaebodDet) {
		// TODO Auto-generated method stub
		return getCxcSession().get(MaebodDet.class, idMaebodDet);
	}

	@Override
	public MaebodDet getMaebodDetByName(String nameMaebodDet) {
		// TODO Auto-generated method stub
		return (MaebodDet) getCxcSession().createQuery("from MaebodDet where nombre = :nameMaebodDet")
				.setParameter("nameMaebodDet", nameMaebodDet).uniqueResult();
	}

	@Override
	public void updateMaebodDet(MaebodDet maebodDet) {
		getCxcSession().update(maebodDet);

	}

	@Override
	public void createMaebodDet(MaebodDet maebodDet) {

		getCxcSession().persist(maebodDet);

	}

	@Override
	public void removeMaebodDet(Long idMaebodDet) {

		MaebodDet maebodDet = getMaebodDetById(idMaebodDet);
		if(maebodDet != null) {
			getCxcSession().delete(maebodDet);
		}

	}

}
