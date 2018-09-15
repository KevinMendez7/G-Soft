package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Fisico;

public interface FisicoService {

	List<Fisico> getFisicoList();

	Fisico getFisicoById(Long idFisico);

	Fisico getFisicoByName(String nameFisico);

	void updateFisico(Fisico fisico);

	void createFisico(Fisico fisico);

	void removeFisico(Long idFisico);

}
