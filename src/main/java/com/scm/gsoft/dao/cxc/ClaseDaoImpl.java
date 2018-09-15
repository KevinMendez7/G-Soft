package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Clase;

@Qualifier("ClaseDaoCxc")
@Repository("ClaseRepositoryCxc")
@Transactional
public class ClaseDaoImpl extends AbstractSession implements ClaseDao {

	@Override
	public List<Clase> getClaseList(){
		return (List<Clase>) getCxcSession().createQuery("from Clase").list();
	}

	@Override
	public Clase getClaseById(Long idClase) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Clase.class, idClase);
	}

	@Override
	public Clase getClaseByName(String nameClase) {
		// TODO Auto-generated method stub
		return (Clase) getCxcSession().createQuery("from Clase where nombre = :nameClase")
				.setParameter("nameClase", nameClase).uniqueResult();
	}

	@Override
	public void updateClase(Clase clase) {
		getCxcSession().update(clase);

	}

	@Override
	public void createClase(Clase clase) {

		getCxcSession().persist(clase);

	}

	@Override
	public void removeClase(Long idClase) {

		Clase clase = getClaseById(idClase);
		if(clase != null) {
			getCxcSession().delete(clase);
		}

	}

}
