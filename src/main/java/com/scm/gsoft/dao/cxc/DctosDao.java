package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Dctos;

public interface DctosDao {

	List<Dctos> getDctosList();

	Dctos getDctosById(Long idDctos);

	Dctos getDctosByName(String nameDctos);

	void updateDctos(Dctos dctos);

	void createDctos(Dctos dctos);

	void removeDctos(Long idDctos);

}
