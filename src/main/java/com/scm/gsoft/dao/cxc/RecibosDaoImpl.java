package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Recibos;

@Repository
@Transactional
public class RecibosDaoImpl extends AbstractSession implements RecibosDao {

	@Override
	public List<Recibos> getRecibosList(){
		return (List<Recibos>) getCxcSession().createQuery("from Recibos").list();
	}

	@Override
	public Recibos getRecibosById(Long idRecibos) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Recibos.class, idRecibos);
	}

	@Override
	public Recibos getRecibosByName(String nameRecibos) {
		// TODO Auto-generated method stub
		return (Recibos) getCxcSession().createQuery("from Recibos where nombre = :nameRecibos")
				.setParameter("nameRecibos", nameRecibos).uniqueResult();
	}

	@Override
	public void updateRecibos(Recibos recibos) {
		getCxcSession().update(recibos);

	}

	@Override
	public void createRecibos(Recibos recibos) {

		getCxcSession().persist(recibos);

	}

	@Override
	public void removeRecibos(Long idRecibos) {

		Recibos recibos = getRecibosById(idRecibos);
		if(recibos != null) {
			getCxcSession().delete(recibos);
		}

	}

}
