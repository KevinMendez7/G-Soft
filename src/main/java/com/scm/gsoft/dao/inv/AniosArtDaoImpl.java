package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.AniosArt;

@Repository
@Transactional
public class AniosArtDaoImpl extends AbstractSession implements AniosArtDao {

	@Override
	public List<AniosArt> getAniosArtList(){
		return (List<AniosArt>) getCxcSession().createQuery("from AniosArt").list();
	}

	@Override
	public AniosArt getAniosArtById(Long idAniosArt) {
		// TODO Auto-generated method stub
		return getCxcSession().get(AniosArt.class, idAniosArt);
	}

	@Override
	public AniosArt getAniosArtByName(String nameAniosArt) {
		// TODO Auto-generated method stub
		return (AniosArt) getCxcSession().createQuery("from AniosArt where nombre = :nameAniosArt")
				.setParameter("nameAniosArt", nameAniosArt).uniqueResult();
	}

	@Override
	public void updateAniosArt(AniosArt aniosArt) {
		getCxcSession().update(aniosArt);

	}

	@Override
	public void createAniosArt(AniosArt aniosArt) {

		getCxcSession().persist(aniosArt);

	}

	@Override
	public void removeAniosArt(Long idAniosArt) {

		AniosArt aniosArt = getAniosArtById(idAniosArt);
		if(aniosArt != null) {
			getCxcSession().delete(aniosArt);
		}

	}

}
