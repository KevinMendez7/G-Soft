package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.MesL;

public interface MesLService {

	List<MesL> getMesLList();

	MesL getMesLById(Long idMesL);

	MesL getMesLByName(String nameMesL);

	void updateMesL(MesL mesL);

	void createMesL(MesL mesL);

	void removeMesL(Long idMesL);

}
