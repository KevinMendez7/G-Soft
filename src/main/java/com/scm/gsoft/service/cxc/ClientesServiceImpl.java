package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.ClientesDao;
import com.scm.gsoft.domain.cxc.Clientes;

@Service("ClientesService")
@Transactional
public class ClientesServiceImpl implements ClientesService {

	@Autowired
	private ClientesDao _clientesDao;

	@Override
	public List<Clientes> getClientesList(){
		return _clientesDao.getClientesList();
	}

	@Override
	public Clientes getClientesById(Long idClientes) {
		// TODO Auto-generated method stub
		return _clientesDao.getClientesById(idClientes);
	}

	@Override
	public Clientes getClientesByName(String nameClientes) {
		// TODO Auto-generated method stub
		return _clientesDao.getClientesByName(nameClientes);
	}

	@Override
	public void updateClientes(Clientes clientes) {

		_clientesDao.updateClientes(clientes);

	}

	@Override
	public void createClientes(Clientes clientes) {

		_clientesDao.createClientes(clientes);

	}

	@Override
	public void removeClientes(Long idClientes) {

		_clientesDao.removeClientes(idClientes);

	}

}
