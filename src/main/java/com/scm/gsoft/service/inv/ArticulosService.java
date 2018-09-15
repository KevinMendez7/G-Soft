package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Articulos;

public interface ArticulosService {

	List<Articulos> getArticulosList();

	Articulos getArticulosById(Long idArticulos);

	Articulos getArticulosByName(String nameArticulos);

	void updateArticulos(Articulos articulos);

	void createArticulos(Articulos articulos);

	void removeArticulos(Long idArticulos);

}
