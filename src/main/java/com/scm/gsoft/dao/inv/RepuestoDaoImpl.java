package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Repuesto;

@Repository
@Transactional
public class RepuestoDaoImpl extends AbstractSession implements RepuestoDao {

	@Override
	public List<Repuesto> getRepuestoList(){
		return (List<Repuesto>) getCxcSession().createQuery("from Repuesto").list();
	}

	@Override
	public Repuesto getRepuestoById(Long idRepuesto) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Repuesto.class, idRepuesto);
	}

	@Override
	public Repuesto getRepuestoByName(String nameRepuesto) {
		// TODO Auto-generated method stub
		return (Repuesto) getCxcSession().createQuery("from Repuesto where nombre = :nameRepuesto")
				.setParameter("nameRepuesto", nameRepuesto).uniqueResult();
	}

	@Override
	public void updateRepuesto(Repuesto repuesto) {
		getCxcSession().update(repuesto);

	}

	@Override
	public void createRepuesto(Repuesto repuesto) {

		getCxcSession().persist(repuesto);

	}

	@Override
	public void removeRepuesto(Long idRepuesto) {

		Repuesto repuesto = getRepuestoById(idRepuesto);
		if(repuesto != null) {
			getCxcSession().delete(repuesto);
		}

	}

}
