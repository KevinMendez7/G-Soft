package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Dctos;

public interface DctosService {

	List<Dctos> getDctosList();

	Dctos getDctosById(Long idDctos);

	Dctos getDctosByName(String nameDctos);

	void updateDctos(Dctos dctos);

	void createDctos(Dctos dctos);

	void removeDctos(Long idDctos);

}
