package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.ComprasD;

public interface ComprasDService {

	List<ComprasD> getComprasDList();

	ComprasD getComprasDById(Long idComprasD);

	ComprasD getComprasDByName(String nameComprasD);

	void updateComprasD(ComprasD comprasD);

	void createComprasD(ComprasD comprasD);

	void removeComprasD(Long idComprasD);

}
