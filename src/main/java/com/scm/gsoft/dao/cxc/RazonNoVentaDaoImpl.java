package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.RazonNoVenta;

@Repository
@Transactional
public class RazonNoVentaDaoImpl extends AbstractSession implements RazonNoVentaDao {

	@Override
	public List<RazonNoVenta> getRazonNoVentaList(){
		return (List<RazonNoVenta>) getCxcSession().createQuery("from RazonNoVenta").list();
	}

	@Override
	public RazonNoVenta getRazonNoVentaById(Long idRazonNoVenta) {
		// TODO Auto-generated method stub
		return getCxcSession().get(RazonNoVenta.class, idRazonNoVenta);
	}

	@Override
	public RazonNoVenta getRazonNoVentaByName(String nameRazonNoVenta) {
		// TODO Auto-generated method stub
		return (RazonNoVenta) getCxcSession().createQuery("from RazonNoVenta where nombre = :nameRazonNoVenta")
				.setParameter("nameRazonNoVenta", nameRazonNoVenta).uniqueResult();
	}

	@Override
	public void updateRazonNoVenta(RazonNoVenta razonNoVenta) {
		getCxcSession().update(razonNoVenta);

	}

	@Override
	public void createRazonNoVenta(RazonNoVenta razonNoVenta) {

		getCxcSession().persist(razonNoVenta);

	}

	@Override
	public void removeRazonNoVenta(Long idRazonNoVenta) {

		RazonNoVenta razonNoVenta = getRazonNoVentaById(idRazonNoVenta);
		if(razonNoVenta != null) {
			getCxcSession().delete(razonNoVenta);
		}

	}

}
