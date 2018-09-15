package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Dolar;

public interface DolarDao {

	List<Dolar> getDolarList();

	Dolar getDolarById(Long idDolar);

	Dolar getDolarByName(String nameDolar);

	void updateDolar(Dolar dolar);

	void createDolar(Dolar dolar);

	void removeDolar(Long idDolar);

}
