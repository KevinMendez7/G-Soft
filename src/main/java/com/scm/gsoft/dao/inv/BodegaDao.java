package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Bodega;

public interface BodegaDao {

	List<Bodega> getBodegaList();

	Bodega getBodegaById(Long idBodega);

	Bodega getBodegaByName(String nameBodega);

	void updateBodega(Bodega bodega);

	void createBodega(Bodega bodega);

	void removeBodega(Long idBodega);

}
