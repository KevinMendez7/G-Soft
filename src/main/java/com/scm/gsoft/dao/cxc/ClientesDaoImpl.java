package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.Clientes;

@Repository
@Transactional
public class ClientesDaoImpl extends AbstractSession implements ClientesDao {

	@Override
	public List<Clientes> getClientesList(){
		return (List<Clientes>) getCxcSession().createQuery("from Clientes").list();
	}

	@Override
	public Clientes getClientesById(Long idClientes) {
		// TODO Auto-generated method stub
		return getCxcSession().get(Clientes.class, idClientes);
	}

	@Override
	public Clientes getClientesByName(String nameClientes) {
		// TODO Auto-generated method stub
		return (Clientes) getCxcSession().createQuery("from Clientes where nombre = :nameClientes")
				.setParameter("nameClientes", nameClientes).uniqueResult();
	}

	@Override
	public void updateClientes(Clientes clientes) {
		getCxcSession().update(clientes);

	}

	@Override
	public void createClientes(Clientes clientes) {

		getCxcSession().persist(clientes);

	}

	@Override
	public void removeClientes(Long idClientes) {

		Clientes clientes = getClientesById(idClientes);
		if(clientes != null) {
			getCxcSession().delete(clientes);
		}

	}

}
