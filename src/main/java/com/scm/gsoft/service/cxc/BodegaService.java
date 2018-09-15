package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Bodega;

public interface BodegaService {

	List<Bodega> getBodegaList();

	Bodega getBodegaById(Long idBodega);

	Bodega getBodegaByCode(String codeBodega);

	void updateBodega(Bodega bodega);

	void createBodega(Bodega bodega);

	void removeBodega(Long idBodega);

}
