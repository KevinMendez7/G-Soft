package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.Provee;

public interface ProveeService {

	List<Provee> getProveeList();

	Provee getProveeById(Long idProvee);

	Provee getProveeByName(String nameProvee);

	void updateProvee(Provee provee);

	void createProvee(Provee provee);

	void removeProvee(Long idProvee);

}
