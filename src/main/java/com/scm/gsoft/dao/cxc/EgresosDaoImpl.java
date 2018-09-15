package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Egresos;

@Repository
@Transactional
public class EgresosDaoImpl extends AbstractSession implements EgresosDao {

	@Override
	public List<Egresos> getEgresosList(){
		return (List<Egresos>) getCxcSession().createQuery("from Egresos").list();
	}

	@Override
	public Egresos getEgresosById(Long idEgresos) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Egresos.class, idEgresos);
	}

	@Override
	public Egresos getEgresosByName(String nameEgresos) {
		// TODO Auto-generated method stub
		return (Egresos) getCxcSession().createQuery("from Egresos where nombre = :nameEgresos")
				.setParameter("nameEgresos", nameEgresos).uniqueResult();
	}

	@Override
	public void updateEgresos(Egresos egresos) {
		getCxcSession().update(egresos);

	}

	@Override
	public void createEgresos(Egresos egresos) {

		getCxcSession().persist(egresos);

	}

	@Override
	public void removeEgresos(Long idEgresos) {

		Egresos egresos = getEgresosById(idEgresos);
		if(egresos != null) {
			getCxcSession().delete(egresos);
		}

	}

}
