package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Bodega;

@Repository
@Transactional
public class BodegaDaoImpl extends AbstractSession implements BodegaDao {

	@Override
	public List<Bodega> getBodegaList(){
		return (List<Bodega>) getCxcSession().createQuery("from Bodega").list();
	}

	@Override
	public Bodega getBodegaById(Long idBodega) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Bodega.class, idBodega);
	}

	@Override
	public Bodega getBodegaByName(String nameBodega) {
		// TODO Auto-generated method stub
		return (Bodega) getCxcSession().createQuery("from Bodega where nombre = :nameBodega")
				.setParameter("nameBodega", nameBodega).uniqueResult();
	}

	@Override
	public void updateBodega(Bodega bodega) {
		getCxcSession().update(bodega);

	}

	@Override
	public void createBodega(Bodega bodega) {

		getCxcSession().persist(bodega);

	}

	@Override
	public void removeBodega(Long idBodega) {

		Bodega bodega = getBodegaById(idBodega);
		if(bodega != null) {
			getCxcSession().delete(bodega);
		}

	}

}
