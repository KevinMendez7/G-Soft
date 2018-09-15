package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Egresos;

public interface EgresosDao {

	List<Egresos> getEgresosList();

	Egresos getEgresosById(Long idEgresos);

	Egresos getEgresosByName(String nameEgresos);

	void updateEgresos(Egresos egresos);

	void createEgresos(Egresos egresos);

	void removeEgresos(Long idEgresos);

}
