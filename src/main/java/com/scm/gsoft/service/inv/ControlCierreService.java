package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.ControlCierre;

public interface ControlCierreService {

	List<ControlCierre> getControlCierreList();

	ControlCierre getControlCierreById(Long idControlCierre);

	ControlCierre getControlCierreByName(String nameControlCierre);

	void updateControlCierre(ControlCierre controlCierre);

	void createControlCierre(ControlCierre controlCierre);

	void removeControlCierre(Long idControlCierre);

}
