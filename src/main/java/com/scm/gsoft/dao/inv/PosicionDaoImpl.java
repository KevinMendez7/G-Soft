package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Posicion;

@Repository
@Transactional
public class PosicionDaoImpl extends AbstractSession implements PosicionDao {

	@Override
	public List<Posicion> getPosicionList(){
		return (List<Posicion>) getCxcSession().createQuery("from Posicion").list();
	}

	@Override
	public Posicion getPosicionById(Long idPosicion) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Posicion.class, idPosicion);
	}

	@Override
	public Posicion getPosicionByName(String namePosicion) {
		// TODO Auto-generated method stub
		return (Posicion) getCxcSession().createQuery("from Posicion where nombre = :namePosicion")
				.setParameter("namePosicion", namePosicion).uniqueResult();
	}

	@Override
	public void updatePosicion(Posicion posicion) {
		getCxcSession().update(posicion);

	}

	@Override
	public void createPosicion(Posicion posicion) {

		getCxcSession().persist(posicion);

	}

	@Override
	public void removePosicion(Long idPosicion) {

		Posicion posicion = getPosicionById(idPosicion);
		if(posicion != null) {
			getCxcSession().delete(posicion);
		}

	}

}
