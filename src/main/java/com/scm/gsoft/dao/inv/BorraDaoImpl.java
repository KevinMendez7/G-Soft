package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Borra;

@Repository
@Transactional
public class BorraDaoImpl extends AbstractSession implements BorraDao {

	@Override
	public List<Borra> getBorraList(){
		return (List<Borra>) getCxcSession().createQuery("from Borra").list();
	}

	@Override
	public Borra getBorraById(Long idBorra) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Borra.class, idBorra);
	}

	@Override
	public Borra getBorraByName(String nameBorra) {
		// TODO Auto-generated method stub
		return (Borra) getCxcSession().createQuery("from Borra where nombre = :nameBorra")
				.setParameter("nameBorra", nameBorra).uniqueResult();
	}

	@Override
	public void updateBorra(Borra borra) {
		getCxcSession().update(borra);

	}

	@Override
	public void createBorra(Borra borra) {

		getCxcSession().persist(borra);

	}

	@Override
	public void removeBorra(Long idBorra) {

		Borra borra = getBorraById(idBorra);
		if(borra != null) {
			getCxcSession().delete(borra);
		}

	}

}
