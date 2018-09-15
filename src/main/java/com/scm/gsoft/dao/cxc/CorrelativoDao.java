package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Correlativo;

public interface CorrelativoDao {

	List<Correlativo> getCorrelativoList();

	Correlativo getCorrelativoById(Long idCorrelativo);

	Correlativo getCorrelativoByName(String nameCorrelativo);

	void updateCorrelativo(Correlativo correlativo);

	void createCorrelativo(Correlativo correlativo);

	void removeCorrelativo(Long idCorrelativo);

}
