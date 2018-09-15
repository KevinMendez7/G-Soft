package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Cotiza;

@Repository
@Transactional
public class CotizaDaoImpl extends AbstractSession implements CotizaDao {

	@Override
	public List<Cotiza> getCotizaList(){
		return (List<Cotiza>) getCxcSession().createQuery("from Cotiza").list();
	}

	@Override
	public Cotiza getCotizaById(Long idCotiza) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Cotiza.class, idCotiza);
	}

	@Override
	public Cotiza getCotizaByName(String nameCotiza) {
		// TODO Auto-generated method stub
		return (Cotiza) getCxcSession().createQuery("from Cotiza where nombre = :nameCotiza")
				.setParameter("nameCotiza", nameCotiza).uniqueResult();
	}

	@Override
	public void updateCotiza(Cotiza cotiza) {
		getCxcSession().update(cotiza);

	}

	@Override
	public void createCotiza(Cotiza cotiza) {

		getCxcSession().persist(cotiza);

	}

	@Override
	public void removeCotiza(Long idCotiza) {

		Cotiza cotiza = getCotizaById(idCotiza);
		if(cotiza != null) {
			getCxcSession().delete(cotiza);
		}

	}

}
