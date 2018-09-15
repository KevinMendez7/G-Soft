package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Hoja1S;

public interface Hoja1SDao {

	List<Hoja1S> getHoja1SList();

	Hoja1S getHoja1SById(Long idHoja1S);

	Hoja1S getHoja1SByName(String nameHoja1S);

	void updateHoja1S(Hoja1S hoja1S);

	void createHoja1S(Hoja1S hoja1S);

	void removeHoja1S(Long idHoja1S);

}
