package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.DetallePl;

public interface DetallePlDao {

	List<DetallePl> getDetallePlList();

	DetallePl getDetallePlById(Long idDetallePl);

	DetallePl getDetallePlByName(String nameDetallePl);

	void updateDetallePl(DetallePl detallePl);

	void createDetallePl(DetallePl detallePl);

	void removeDetallePl(Long idDetallePl);

}
