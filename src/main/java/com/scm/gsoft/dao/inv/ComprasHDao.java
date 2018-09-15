package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.ComprasH;

public interface ComprasHDao {

	List<ComprasH> getComprasHList();

	ComprasH getComprasHById(Long idComprasH);

	ComprasH getComprasHByName(String nameComprasH);

	void updateComprasH(ComprasH comprasH);

	void createComprasH(ComprasH comprasH);

	void removeComprasH(Long idComprasH);

}
