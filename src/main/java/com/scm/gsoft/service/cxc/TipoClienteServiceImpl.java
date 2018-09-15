package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.TipoClienteDao;
import com.scm.gsoft.domain.cxc.TipoCliente;

@Service("TipoClienteService")
@Transactional
public class TipoClienteServiceImpl implements TipoClienteService {

	@Autowired
	private TipoClienteDao _tipoClienteDao;

	@Override
	public List<TipoCliente> getTipoClienteList(){
		return _tipoClienteDao.getTipoClienteList();
	}

	@Override
	public TipoCliente getTipoClienteById(Long idTipoCliente) {
		// TODO Auto-generated method stub
		return _tipoClienteDao.getTipoClienteById(idTipoCliente);
	}

	@Override
	public TipoCliente getTipoClienteByName(String nameTipoCliente) {
		// TODO Auto-generated method stub
		return _tipoClienteDao.getTipoClienteByName(nameTipoCliente);
	}

	@Override
	public void updateTipoCliente(TipoCliente tipoCliente) {

		_tipoClienteDao.updateTipoCliente(tipoCliente);

	}

	@Override
	public void createTipoCliente(TipoCliente tipoCliente) {

		_tipoClienteDao.createTipoCliente(tipoCliente);

	}

	@Override
	public void removeTipoCliente(Long idTipoCliente) {

		_tipoClienteDao.removeTipoCliente(idTipoCliente);

	}

}
