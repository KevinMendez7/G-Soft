package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Lado;

public interface LadoService {

	List<Lado> getLadoList();

	Lado getLadoById(Long idLado);

	Lado getLadoByName(String nameLado);

	void updateLado(Lado lado);

	void createLado(Lado lado);

	void removeLado(Long idLado);

}
