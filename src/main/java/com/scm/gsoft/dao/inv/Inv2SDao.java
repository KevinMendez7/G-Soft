package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Inv2S;

public interface Inv2SDao {

	List<Inv2S> getInv2SList();

	Inv2S getInv2SById(Long idInv2S);

	Inv2S getInv2SByName(String nameInv2S);

	void updateInv2S(Inv2S inv2S);

	void createInv2S(Inv2S inv2S);

	void removeInv2S(Long idInv2S);

}
