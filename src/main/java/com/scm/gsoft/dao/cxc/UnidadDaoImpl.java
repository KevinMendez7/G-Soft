package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Unidad;

@Qualifier("UnidadDaoCxc")
@Repository("UnidadRepositoryCxc")
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
