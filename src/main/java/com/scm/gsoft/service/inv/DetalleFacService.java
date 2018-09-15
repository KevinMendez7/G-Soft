package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.DetalleFac;

public interface DetalleFacService {

	List<DetalleFac> getDetalleFacList();

	DetalleFac getDetalleFacById(Long idDetalleFac);

	DetalleFac getDetalleFacByName(String nameDetalleFac);

	void updateDetalleFac(DetalleFac detalleFac);

	void createDetalleFac(DetalleFac detalleFac);

	void removeDetalleFac(Long idDetalleFac);

}
