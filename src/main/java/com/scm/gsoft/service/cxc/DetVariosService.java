package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.DetVarios;

public interface DetVariosService {

	List<DetVarios> getDetVariosList();

	DetVarios getDetVariosById(Long idDetVarios);

	DetVarios getDetVariosByName(String nameDetVarios);

	void updateDetVarios(DetVarios detVarios);

	void createDetVarios(DetVarios detVarios);

	void removeDetVarios(Long idDetVarios);

}
