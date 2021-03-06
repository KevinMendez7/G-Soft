package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.ClientesSinCompras;

public interface ClientesSinComprasDao {

	List<ClientesSinCompras> getClientesSinComprasList();

	ClientesSinCompras getClientesSinComprasById(Long idClientesSinCompras);

	ClientesSinCompras getClientesSinComprasByName(String nameClientesSinCompras);

	void updateClientesSinCompras(ClientesSinCompras clientesSinCompras);

	void createClientesSinCompras(ClientesSinCompras clientesSinCompras);

	void removeClientesSinCompras(Long idClientesSinCompras);

}
