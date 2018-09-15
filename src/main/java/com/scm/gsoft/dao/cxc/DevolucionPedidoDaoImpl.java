package com.scm.gsoft.dao.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.scm.gsoft.domain.cxc.DevolucionPedido;

@Repository
@Transactional
public class DevolucionPedidoDaoImpl extends AbstractSession implements DevolucionPedidoDao {

	@Override
	public List<DevolucionPedido> getDevolucionPedidoList(){
		return (List<DevolucionPedido>) getCxcSession().createQuery("from DevolucionPedido").list();
	}

	@Override
	public DevolucionPedido getDevolucionPedidoById(Long idDevolucionPedido) {
		// TODO Auto-generated method stub
		return getCxcSession().get(DevolucionPedido.class, idDevolucionPedido);
	}

	@Override
	public DevolucionPedido getDevolucionPedidoByName(String nameDevolucionPedido) {
		// TODO Auto-generated method stub
		return (DevolucionPedido) getCxcSession().createQuery("from DevolucionPedido where nombre = :nameDevolucionPedido")
				.setParameter("nameDevolucionPedido", nameDevolucionPedido).uniqueResult();
	}

	@Override
	public void updateDevolucionPedido(DevolucionPedido devolucionPedido) {
		getCxcSession().update(devolucionPedido);

	}

	@Override
	public void createDevolucionPedido(DevolucionPedido devolucionPedido) {

		getCxcSession().persist(devolucionPedido);

	}

	@Override
	public void removeDevolucionPedido(Long idDevolucionPedido) {

		DevolucionPedido devolucionPedido = getDevolucionPedidoById(idDevolucionPedido);
		if(devolucionPedido != null) {
			getCxcSession().delete(devolucionPedido);
		}

	}

}
