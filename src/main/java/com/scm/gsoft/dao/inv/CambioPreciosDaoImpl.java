package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.CambioPrecios;

@Repository
@Transactional
public class CambioPreciosDaoImpl extends AbstractSession implements CambioPreciosDao {

	@Override
	public List<CambioPrecios> getCambioPreciosList(){
		return (List<CambioPrecios>) getCxcSession().createQuery("from CambioPrecios").list();
	}

	@Override
	public CambioPrecios getCambioPreciosById(Long idCambioPrecios) {
		// TODO Auto-generated method stub
		return getCxcSession().get(CambioPrecios.class, idCambioPrecios);
	}

	@Override
	public CambioPrecios getCambioPreciosByName(String nameCambioPrecios) {
		// TODO Auto-generated method stub
		return (CambioPrecios) getCxcSession().createQuery("from CambioPrecios where nombre = :nameCambioPrecios")
				.setParameter("nameCambioPrecios", nameCambioPrecios).uniqueResult();
	}

	@Override
	public void updateCambioPrecios(CambioPrecios cambioPrecios) {
		getCxcSession().update(cambioPrecios);

	}

	@Override
	public void createCambioPrecios(CambioPrecios cambioPrecios) {

		getCxcSession().persist(cambioPrecios);

	}

	@Override
	public void removeCambioPrecios(Long idCambioPrecios) {

		CambioPrecios cambioPrecios = getCambioPreciosById(idCambioPrecios);
		if(cambioPrecios != null) {
			getCxcSession().delete(cambioPrecios);
		}

	}

}
