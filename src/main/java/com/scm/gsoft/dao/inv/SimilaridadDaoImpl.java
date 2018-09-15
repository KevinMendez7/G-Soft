package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Similaridad;

@Repository
@Transactional
public class SimilaridadDaoImpl extends AbstractSession implements SimilaridadDao {

	@Override
	public List<Similaridad> getSimilaridadList(){
		return (List<Similaridad>) getCxcSession().createQuery("from Similaridad").list();
	}

	@Override
	public Similaridad getSimilaridadById(Long idSimilaridad) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Similaridad.class, idSimilaridad);
	}

	@Override
	public Similaridad getSimilaridadByName(String nameSimilaridad) {
		// TODO Auto-generated method stub
		return (Similaridad) getCxcSession().createQuery("from Similaridad where nombre = :nameSimilaridad")
				.setParameter("nameSimilaridad", nameSimilaridad).uniqueResult();
	}

	@Override
	public void updateSimilaridad(Similaridad similaridad) {
		getCxcSession().update(similaridad);

	}

	@Override
	public void createSimilaridad(Similaridad similaridad) {

		getCxcSession().persist(similaridad);

	}

	@Override
	public void removeSimilaridad(Long idSimilaridad) {

		Similaridad similaridad = getSimilaridadById(idSimilaridad);
		if(similaridad != null) {
			getCxcSession().delete(similaridad);
		}

	}

}
