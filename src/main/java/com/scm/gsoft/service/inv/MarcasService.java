package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Marcas;

public interface MarcasService {

	List<Marcas> getMarcasList();

	Marcas getMarcasById(Long idMarcas);

	Marcas getMarcasByName(String nameMarcas);

	void updateMarcas(Marcas marcas);

	void createMarcas(Marcas marcas);

	void removeMarcas(Long idMarcas);

}
