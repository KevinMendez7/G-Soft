package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.ComprasD;

public interface ComprasDDao {

	List<ComprasD> getComprasDList();

	ComprasD getComprasDById(Long idComprasD);

	ComprasD getComprasDByName(String nameComprasD);

	void updateComprasD(ComprasD comprasD);

	void createComprasD(ComprasD comprasD);

	void removeComprasD(Long idComprasD);

}
