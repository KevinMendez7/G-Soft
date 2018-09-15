package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Clientes;

public interface ClientesDao {

	List<Clientes> getClientesList();

	Clientes getClientesById(Long idClientes);

	Clientes getClientesByName(String nameClientes);

	void updateClientes(Clientes clientes);

	void createClientes(Clientes clientes);

	void removeClientes(Long idClientes);

}
