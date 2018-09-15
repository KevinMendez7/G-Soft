package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Tarjeta;

@Repository
@Transactional
public class TarjetaDaoImpl extends AbstractSession implements TarjetaDao {

	@Override
	public List<Tarjeta> getTarjetaList(){
		return (List<Tarjeta>) getCxcSession().createQuery("from Tarjeta").list();
	}

	@Override
	public Tarjeta getTarjetaById(Long idTarjeta) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Tarjeta.class, idTarjeta);
	}

	@Override
	public Tarjeta getTarjetaByName(String nameTarjeta) {
		// TODO Auto-generated method stub
		return (Tarjeta) getCxcSession().createQuery("from Tarjeta where nombre = :nameTarjeta")
				.setParameter("nameTarjeta", nameTarjeta).uniqueResult();
	}

	@Override
	public void updateTarjeta(Tarjeta tarjeta) {
		getCxcSession().update(tarjeta);

	}

	@Override
	public void createTarjeta(Tarjeta tarjeta) {

		getCxcSession().persist(tarjeta);

	}

	@Override
	public void removeTarjeta(Long idTarjeta) {

		Tarjeta tarjeta = getTarjetaById(idTarjeta);
		if(tarjeta != null) {
			getCxcSession().delete(tarjeta);
		}

	}

}
