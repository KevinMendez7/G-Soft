package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Calidad;

@Repository
@Transactional
public class CalidadDaoImpl extends AbstractSession implements CalidadDao {

	@Override
	public List<Calidad> getCalidadList(){
		return (List<Calidad>) getCxcSession().createQuery("from Calidad").list();
	}

	@Override
	public Calidad getCalidadById(Long idCalidad) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Calidad.class, idCalidad);
	}

	@Override
	public Calidad getCalidadByName(String nameCalidad) {
		// TODO Auto-generated method stub
		return (Calidad) getCxcSession().createQuery("from Calidad where nombre = :nameCalidad")
				.setParameter("nameCalidad", nameCalidad).uniqueResult();
	}

	@Override
	public void updateCalidad(Calidad calidad) {
		getCxcSession().update(calidad);

	}

	@Override
	public void createCalidad(Calidad calidad) {

		getCxcSession().persist(calidad);

	}

	@Override
	public void removeCalidad(Long idCalidad) {

		Calidad calidad = getCalidadById(idCalidad);
		if(calidad != null) {
			getCxcSession().delete(calidad);
		}

	}

}
