package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Bodega;

@Qualifier("BodegaDaoCxc")
@Repository("BodegaRepositoryCxc")
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
	public Bodega getBodegaByCode(String codeBodega) {
		// TODO Auto-generated method stub
		return (Bodega) getCxcSession().createQuery("from Bodega where nombre = :codeBodega")
				.setParameter("codeBodega", codeBodega).uniqueResult();
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
