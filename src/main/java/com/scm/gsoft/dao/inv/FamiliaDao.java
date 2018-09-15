package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Familia;

public interface FamiliaDao {

	List<Familia> getFamiliaList();

	Familia getFamiliaById(Long idFamilia);

	Familia getFamiliaByName(String nameFamilia);

	void updateFamilia(Familia familia);

	void createFamilia(Familia familia);

	void removeFamilia(Long idFamilia);

}
