package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.CotizaH;

@Repository
@Transactional
public class CotizaHDaoImpl extends AbstractSession implements CotizaHDao {

	@Override
	public List<CotizaH> getCotizaHList(){
		return (List<CotizaH>) getCxcSession().createQuery("from CotizaH").list();
	}

	@Override
	public CotizaH getCotizaHById(Long idCotizaH) {
		// TODO Auto-generated method stub
		return getCxcSession().get(CotizaH.class, idCotizaH);
	}

	@Override
	public CotizaH getCotizaHByName(String nameCotizaH) {
		// TODO Auto-generated method stub
		return (CotizaH) getCxcSession().createQuery("from CotizaH where nombre = :nameCotizaH")
				.setParameter("nameCotizaH", nameCotizaH).uniqueResult();
	}

	@Override
	public void updateCotizaH(CotizaH cotizaH) {
		getCxcSession().update(cotizaH);

	}

	@Override
	public void createCotizaH(CotizaH cotizaH) {

		getCxcSession().persist(cotizaH);

	}

	@Override
	public void removeCotizaH(Long idCotizaH) {

		CotizaH cotizaH = getCotizaHById(idCotizaH);
		if(cotizaH != null) {
			getCxcSession().delete(cotizaH);
		}

	}

}
