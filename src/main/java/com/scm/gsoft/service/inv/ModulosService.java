package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Modulos;

public interface ModulosService {

	List<Modulos> getModulosList();

	Modulos getModulosById(Long idModulos);

	Modulos getModulosByName(String nameModulos);

	void updateModulos(Modulos modulos);

	void createModulos(Modulos modulos);

	void removeModulos(Long idModulos);

}
