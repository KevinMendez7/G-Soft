package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.DevolucionPedido;

public interface DevolucionPedidoDao {

	List<DevolucionPedido> getDevolucionPedidoList();

	DevolucionPedido getDevolucionPedidoById(Long idDevolucionPedido);

	DevolucionPedido getDevolucionPedidoByName(String nameDevolucionPedido);

	void updateDevolucionPedido(DevolucionPedido devolucionPedido);

	void createDevolucionPedido(DevolucionPedido devolucionPedido);

	void removeDevolucionPedido(Long idDevolucionPedido);

}
