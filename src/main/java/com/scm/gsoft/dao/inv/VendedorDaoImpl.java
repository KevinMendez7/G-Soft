package com.scm.gsoft.dao.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.inv.Vendedor;

@Repository
@Transactional
public class VendedorDaoImpl extends AbstractSession implements VendedorDao {

	@Override
	public List<Vendedor> getVendedorList(){
		return (List<Vendedor>) getCxcSession().createQuery("from Vendedor").list();
	}

	@Override
	public Vendedor getVendedorById(Long idVendedor) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Vendedor.class, idVendedor);
	}

	@Override
	public Vendedor getVendedorByName(String nameVendedor) {
		// TODO Auto-generated method stub
		return (Vendedor) getCxcSession().createQuery("from Vendedor where nombre = :nameVendedor")
				.setParameter("nameVendedor", nameVendedor).uniqueResult();
	}

	@Override
	public void updateVendedor(Vendedor vendedor) {
		getCxcSession().update(vendedor);

	}

	@Override
	public void createVendedor(Vendedor vendedor) {

		getCxcSession().persist(vendedor);

	}

	@Override
	public void removeVendedor(Long idVendedor) {

		Vendedor vendedor = getVendedorById(idVendedor);
		if(vendedor != null) {
			getCxcSession().delete(vendedor);
		}

	}

}
