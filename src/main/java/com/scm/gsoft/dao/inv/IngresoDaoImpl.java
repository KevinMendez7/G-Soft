package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Ingreso;

@Repository
@Transactional
public class IngresoDaoImpl extends AbstractSession implements IngresoDao {

	@Override
	public List<Ingreso> getIngresoList(){
		return (List<Ingreso>) getCxcSession().createQuery("from Ingreso").list();
	}

	@Override
	public Ingreso getIngresoById(Long idIngreso) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Ingreso.class, idIngreso);
	}

	@Override
	public Ingreso getIngresoByName(String nameIngreso) {
		// TODO Auto-generated method stub
		return (Ingreso) getCxcSession().createQuery("from Ingreso where nombre = :nameIngreso")
				.setParameter("nameIngreso", nameIngreso).uniqueResult();
	}

	@Override
	public void updateIngreso(Ingreso ingreso) {
		getCxcSession().update(ingreso);

	}

	@Override
	public void createIngreso(Ingreso ingreso) {

		getCxcSession().persist(ingreso);

	}

	@Override
	public void removeIngreso(Long idIngreso) {

		Ingreso ingreso = getIngresoById(idIngreso);
		if(ingreso != null) {
			getCxcSession().delete(ingreso);
		}

	}

}
