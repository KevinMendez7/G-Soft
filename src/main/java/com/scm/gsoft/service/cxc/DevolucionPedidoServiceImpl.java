package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.DevolucionPedidoDao;
import com.scm.gsoft.domain.cxc.DevolucionPedido;

@Service("DevolucionPedidoService")
@Transactional
public class DevolucionPedidoServiceImpl implements DevolucionPedidoService {

	@Autowired
	private DevolucionPedidoDao _devolucionPedidoDao;

	@Override
	public List<DevolucionPedido> getDevolucionPedidoList(){
		return _devolucionPedidoDao.getDevolucionPedidoList();
	}

	@Override
	public DevolucionPedido getDevolucionPedidoById(Long idDevolucionPedido) {
		// TODO Auto-generated method stub
		return _devolucionPedidoDao.getDevolucionPedidoById(idDevolucionPedido);
	}

	@Override
	public DevolucionPedido getDevolucionPedidoByName(String nameDevolucionPedido) {
		// TODO Auto-generated method stub
		return _devolucionPedidoDao.getDevolucionPedidoByName(nameDevolucionPedido);
	}

	@Override
	public void updateDevolucionPedido(DevolucionPedido devolucionPedido) {

		_devolucionPedidoDao.updateDevolucionPedido(devolucionPedido);

	}

	@Override
	public void createDevolucionPedido(DevolucionPedido devolucionPedido) {

		_devolucionPedidoDao.createDevolucionPedido(devolucionPedido);

	}

	@Override
	public void removeDevolucionPedido(Long idDevolucionPedido) {

		_devolucionPedidoDao.removeDevolucionPedido(idDevolucionPedido);

	}

}
