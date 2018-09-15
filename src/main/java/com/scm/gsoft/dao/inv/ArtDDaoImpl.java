package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.ArtD;

@Repository
@Transactional
public class ArtDDaoImpl extends AbstractSession implements ArtDDao {

	@Override
	public List<ArtD> getArtDList(){
		return (List<ArtD>) getCxcSession().createQuery("from ArtD").list();
	}

	@Override
	public ArtD getArtDById(Long idArtD) {
		// TODO Auto-generated method stub
		return getCxcSession().get(ArtD.class, idArtD);
	}

	@Override
	public ArtD getArtDByName(String nameArtD) {
		// TODO Auto-generated method stub
		return (ArtD) getCxcSession().createQuery("from ArtD where nombre = :nameArtD")
				.setParameter("nameArtD", nameArtD).uniqueResult();
	}

	@Override
	public void updateArtD(ArtD artD) {
		getCxcSession().update(artD);

	}

	@Override
	public void createArtD(ArtD artD) {

		getCxcSession().persist(artD);

	}

	@Override
	public void removeArtD(Long idArtD) {

		ArtD artD = getArtDById(idArtD);
		if(artD != null) {
			getCxcSession().delete(artD);
		}

	}

}
