package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Graf;

public interface GrafService {

	List<Graf> getGrafList();

	Graf getGrafById(Long idGraf);

	Graf getGrafByName(String nameGraf);

	void updateGraf(Graf graf);

	void createGraf(Graf graf);

	void removeGraf(Long idGraf);

}
