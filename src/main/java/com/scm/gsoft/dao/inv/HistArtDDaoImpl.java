package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.HistArtD;

@Repository
@Transactional
public class HistArtDDaoImpl extends AbstractSession implements HistArtDDao {

	@Override
	public List<HistArtD> getHistArtDList(){
		return (List<HistArtD>) getCxcSession().createQuery("from HistArtD").list();
	}

	@Override
	public HistArtD getHistArtDById(Long idHistArtD) {
		// TODO Auto-generated method stub
		return getCxcSession().get(HistArtD.class, idHistArtD);
	}

	@Override
	public HistArtD getHistArtDByName(String nameHistArtD) {
		// TODO Auto-generated method stub
		return (HistArtD) getCxcSession().createQuery("from HistArtD where nombre = :nameHistArtD")
				.setParameter("nameHistArtD", nameHistArtD).uniqueResult();
	}

	@Override
	public void updateHistArtD(HistArtD histArtD) {
		getCxcSession().update(histArtD);

	}

	@Override
	public void createHistArtD(HistArtD histArtD) {

		getCxcSession().persist(histArtD);

	}

	@Override
	public void removeHistArtD(Long idHistArtD) {

		HistArtD histArtD = getHistArtDById(idHistArtD);
		if(histArtD != null) {
			getCxcSession().delete(histArtD);
		}

	}

}
