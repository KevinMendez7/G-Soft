package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.DetalleRec;

public interface DetalleRecDao {

	List<DetalleRec> getDetalleRecList();

	DetalleRec getDetalleRecById(Long idDetalleRec);

	DetalleRec getDetalleRecByName(String nameDetalleRec);

	void updateDetalleRec(DetalleRec detalleRec);

	void createDetalleRec(DetalleRec detalleRec);

	void removeDetalleRec(Long idDetalleRec);

}
