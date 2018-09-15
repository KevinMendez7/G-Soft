package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Ingreso;

public interface IngresoDao {

	List<Ingreso> getIngresoList();

	Ingreso getIngresoById(Long idIngreso);

	Ingreso getIngresoByName(String nameIngreso);

	void updateIngreso(Ingreso ingreso);

	void createIngreso(Ingreso ingreso);

	void removeIngreso(Long idIngreso);

}
