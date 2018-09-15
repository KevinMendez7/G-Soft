package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Modulos;

public interface ModulosDao {

	List<Modulos> getModulosList();

	Modulos getModulosById(Long idModulos);

	Modulos getModulosByName(String nameModulos);

	void updateModulos(Modulos modulos);

	void createModulos(Modulos modulos);

	void removeModulos(Long idModulos);

}
