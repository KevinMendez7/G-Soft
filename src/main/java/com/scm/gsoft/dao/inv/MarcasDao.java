package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Marcas;

public interface MarcasDao {

	List<Marcas> getMarcasList();

	Marcas getMarcasById(Long idMarcas);

	Marcas getMarcasByName(String nameMarcas);

	void updateMarcas(Marcas marcas);

	void createMarcas(Marcas marcas);

	void removeMarcas(Long idMarcas);

}
