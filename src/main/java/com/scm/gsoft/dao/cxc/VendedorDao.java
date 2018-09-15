package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Vendedor;

public interface VendedorDao {

	List<Vendedor> getVendedorList();

	Vendedor getVendedorById(Long idVendedor);

	Vendedor getVendedorByName(String nameVendedor);

	void updateVendedor(Vendedor vendedor);

	void createVendedor(Vendedor vendedor);

	void removeVendedor(Long idVendedor);

}
