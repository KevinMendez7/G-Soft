package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.ClientesSinComprasDao;
import com.scm.gsoft.domain.cxc.ClientesSinCompras;

@Service("ClientesSinComprasService")
@Transactional
public class ClientesSinComprasServiceImpl implements ClientesSinComprasService {

	@Autowired
	private ClientesSinComprasDao _clientesSinComprasDao;

	@Override
	public List<ClientesSinCompras> getClientesSinComprasList(){
		return _clientesSinComprasDao.getClientesSinComprasList();
	}

	@Override
	public ClientesSinCompras getClientesSinComprasById(Long idClientesSinCompras) {
		// TODO Auto-generated method stub
		return _clientesSinComprasDao.getClientesSinComprasById(idClientesSinCompras);
	}

	@Override
	public ClientesSinCompras getClientesSinComprasByName(String nameClientesSinCompras) {
		// TODO Auto-generated method stub
		return _clientesSinComprasDao.getClientesSinComprasByName(nameClientesSinCompras);
	}

	@Override
	public void updateClientesSinCompras(ClientesSinCompras clientesSinCompras) {

		_clientesSinComprasDao.updateClientesSinCompras(clientesSinCompras);

	}

	@Override
	public void createClientesSinCompras(ClientesSinCompras clientesSinCompras) {

		_clientesSinComprasDao.createClientesSinCompras(clientesSinCompras);

	}

	@Override
	public void removeClientesSinCompras(Long idClientesSinCompras) {

		_clientesSinComprasDao.removeClientesSinCompras(idClientesSinCompras);

	}

}
