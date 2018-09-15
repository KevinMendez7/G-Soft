package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Vendedor;

public interface VendedorService {

	List<Vendedor> getVendedorList();

	Vendedor getVendedorById(Long idVendedor);

	Vendedor getVendedorByName(String nameVendedor);

	void updateVendedor(Vendedor vendedor);

	void createVendedor(Vendedor vendedor);

	void removeVendedor(Long idVendedor);

}
