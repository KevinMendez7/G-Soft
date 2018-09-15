package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.UsuarioVendedor;

public interface UsuarioVendedorService {

	List<UsuarioVendedor> getUsuarioVendedorList();

	UsuarioVendedor getUsuarioVendedorById(Long idUsuarioVendedor);

	UsuarioVendedor getUsuarioVendedorByName(String nameUsuarioVendedor);

	void updateUsuarioVendedor(UsuarioVendedor usuarioVendedor);

	void createUsuarioVendedor(UsuarioVendedor usuarioVendedor);

	void removeUsuarioVendedor(Long idUsuarioVendedor);

}
