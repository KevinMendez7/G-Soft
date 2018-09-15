package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.ArtH;

@Repository
@Transactional
public class ArtHDaoImpl extends AbstractSession implements ArtHDao {

	@Override
	public List<ArtH> getArtHList(){
		return (List<ArtH>) getCxcSession().createQuery("from ArtH").list();
	}

	@Override
	public ArtH getArtHById(Long idArtH) {
		// TODO Auto-generated method stub
		return getCxcSession().get(ArtH.class, idArtH);
	}

	@Override
	public ArtH getArtHByName(String nameArtH) {
		// TODO Auto-generated method stub
		return (ArtH) getCxcSession().createQuery("from ArtH where nombre = :nameArtH")
				.setParameter("nameArtH", nameArtH).uniqueResult();
	}

	@Override
	public void updateArtH(ArtH artH) {
		getCxcSession().update(artH);

	}

	@Override
	public void createArtH(ArtH artH) {

		getCxcSession().persist(artH);

	}

	@Override
	public void removeArtH(Long idArtH) {

		ArtH artH = getArtHById(idArtH);
		if(artH != null) {
			getCxcSession().delete(artH);
		}

	}

}
