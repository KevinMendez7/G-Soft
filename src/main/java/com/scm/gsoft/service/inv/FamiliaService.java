package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Familia;

public interface FamiliaService {

	List<Familia> getFamiliaList();

	Familia getFamiliaById(Long idFamilia);

	Familia getFamiliaByName(String nameFamilia);

	void updateFamilia(Familia familia);

	void createFamilia(Familia familia);

	void removeFamilia(Long idFamilia);

}
