package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.HistArtH;

@Repository
@Transactional
public class HistArtHDaoImpl extends AbstractSession implements HistArtHDao {

	@Override
	public List<HistArtH> getHistArtHList(){
		return (List<HistArtH>) getCxcSession().createQuery("from HistArtH").list();
	}

	@Override
	public HistArtH getHistArtHById(Long idHistArtH) {
		// TODO Auto-generated method stub
		return getCxcSession().get(HistArtH.class, idHistArtH);
	}

	@Override
	public HistArtH getHistArtHByName(String nameHistArtH) {
		// TODO Auto-generated method stub
		return (HistArtH) getCxcSession().createQuery("from HistArtH where nombre = :nameHistArtH")
				.setParameter("nameHistArtH", nameHistArtH).uniqueResult();
	}

	@Override
	public void updateHistArtH(HistArtH histArtH) {
		getCxcSession().update(histArtH);

	}

	@Override
	public void createHistArtH(HistArtH histArtH) {

		getCxcSession().persist(histArtH);

	}

	@Override
	public void removeHistArtH(Long idHistArtH) {

		HistArtH histArtH = getHistArtHById(idHistArtH);
		if(histArtH != null) {
			getCxcSession().delete(histArtH);
		}

	}

}
