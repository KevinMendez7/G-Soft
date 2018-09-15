package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Unidad;

@Repository
@Transactional
public class UnidadDaoImpl extends AbstractSession implements UnidadDao {

	@Override
	public List<Unidad> getUnidadList(){
		return (List<Unidad>) getCxcSession().createQuery("from Unidad").list();
	}

	@Override
	public Unidad getUnidadById(Long idUnidad) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Unidad.class, idUnidad);
	}

	@Override
	public Unidad getUnidadByName(String nameUnidad) {
		// TODO Auto-generated method stub
		return (Unidad) getCxcSession().createQuery("from Unidad where nombre = :nameUnidad")
				.setParameter("nameUnidad", nameUnidad).uniqueResult();
	}

	@Override
	public void updateUnidad(Unidad unidad) {
		getCxcSession().update(unidad);

	}

	@Override
	public void createUnidad(Unidad unidad) {

		getCxcSession().persist(unidad);

	}

	@Override
	public void removeUnidad(Long idUnidad) {

		Unidad unidad = getUnidadById(idUnidad);
		if(unidad != null) {
			getCxcSession().delete(unidad);
		}

	}

}
