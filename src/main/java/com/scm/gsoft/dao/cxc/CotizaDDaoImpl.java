package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.CotizaD;

@Repository
@Transactional
public class CotizaDDaoImpl extends AbstractSession implements CotizaDDao {

	@Override
	public List<CotizaD> getCotizaDList(){
		return (List<CotizaD>) getCxcSession().createQuery("from CotizaD").list();
	}

	@Override
	public CotizaD getCotizaDById(Long idCotizaD) {
		// TODO Auto-generated method stub
		return getCxcSession().get(CotizaD.class, idCotizaD);
	}

	@Override
	public CotizaD getCotizaDByName(String nameCotizaD) {
		// TODO Auto-generated method stub
		return (CotizaD) getCxcSession().createQuery("from CotizaD where nombre = :nameCotizaD")
				.setParameter("nameCotizaD", nameCotizaD).uniqueResult();
	}

	@Override
	public void updateCotizaD(CotizaD cotizaD) {
		getCxcSession().update(cotizaD);

	}

	@Override
	public void createCotizaD(CotizaD cotizaD) {

		getCxcSession().persist(cotizaD);

	}

	@Override
	public void removeCotizaD(Long idCotizaD) {

		CotizaD cotizaD = getCotizaDById(idCotizaD);
		if(cotizaD != null) {
			getCxcSession().delete(cotizaD);
		}

	}

}
