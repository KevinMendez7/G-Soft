package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.ClientesSinCompras;

@Repository
@Transactional
public class ClientesSinComprasDaoImpl extends AbstractSession implements ClientesSinComprasDao {

	@Override
	public List<ClientesSinCompras> getClientesSinComprasList(){
		return (List<ClientesSinCompras>) getCxcSession().createQuery("from ClientesSinCompras").list();
	}

	@Override
	public ClientesSinCompras getClientesSinComprasById(Long idClientesSinCompras) {
		// TODO Auto-generated method stub
		return getCxcSession().get(ClientesSinCompras.class, idClientesSinCompras);
	}

	@Override
	public ClientesSinCompras getClientesSinComprasByName(String nameClientesSinCompras) {
		// TODO Auto-generated method stub
		return (ClientesSinCompras) getCxcSession().createQuery("from ClientesSinCompras where nombre = :nameClientesSinCompras")
				.setParameter("nameClientesSinCompras", nameClientesSinCompras).uniqueResult();
	}

	@Override
	public void updateClientesSinCompras(ClientesSinCompras clientesSinCompras) {
		getCxcSession().update(clientesSinCompras);

	}

	@Override
	public void createClientesSinCompras(ClientesSinCompras clientesSinCompras) {

		getCxcSession().persist(clientesSinCompras);

	}

	@Override
	public void removeClientesSinCompras(Long idClientesSinCompras) {

		ClientesSinCompras clientesSinCompras = getClientesSinComprasById(idClientesSinCompras);
		if(clientesSinCompras != null) {
			getCxcSession().delete(clientesSinCompras);
		}

	}

}
