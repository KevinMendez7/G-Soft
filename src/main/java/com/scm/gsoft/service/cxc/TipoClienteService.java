package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.TipoCliente;

public interface TipoClienteService {

	List<TipoCliente> getTipoClienteList();

	TipoCliente getTipoClienteById(Long idTipoCliente);

	TipoCliente getTipoClienteByName(String nameTipoCliente);

	void updateTipoCliente(TipoCliente tipoCliente);

	void createTipoCliente(TipoCliente tipoCliente);

	void removeTipoCliente(Long idTipoCliente);

}
