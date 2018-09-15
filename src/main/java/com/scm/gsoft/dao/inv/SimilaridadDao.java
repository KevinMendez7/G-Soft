package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Similaridad;

public interface SimilaridadDao {

	List<Similaridad> getSimilaridadList();

	Similaridad getSimilaridadById(Long idSimilaridad);

	Similaridad getSimilaridadByName(String nameSimilaridad);

	void updateSimilaridad(Similaridad similaridad);

	void createSimilaridad(Similaridad similaridad);

	void removeSimilaridad(Long idSimilaridad);

}
