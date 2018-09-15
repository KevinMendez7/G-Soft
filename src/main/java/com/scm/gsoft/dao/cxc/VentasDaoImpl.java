package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Ventas;

@Repository
@Transactional
public class VentasDaoImpl extends AbstractSession implements VentasDao {

	@Override
	public List<Ventas> getVentasList(){
		return (List<Ventas>) getCxcSession().createQuery("from Ventas").list();
	}

	@Override
	public Ventas getVentasById(Long idVentas) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Ventas.class, idVentas);
	}

	@Override
	public Ventas getVentasByName(String nameVentas) {
		// TODO Auto-generated method stub
		return (Ventas) getCxcSession().createQuery("from Ventas where nombre = :nameVentas")
				.setParameter("nameVentas", nameVentas).uniqueResult();
	}

	@Override
	public void updateVentas(Ventas ventas) {
		getCxcSession().update(ventas);

	}

	@Override
	public void createVentas(Ventas ventas) {

		getCxcSession().persist(ventas);

	}

	@Override
	public void removeVentas(Long idVentas) {

		Ventas ventas = getVentasById(idVentas);
		if(ventas != null) {
			getCxcSession().delete(ventas);
		}

	}

}
