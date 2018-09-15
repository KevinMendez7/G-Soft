package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.Provee;

public interface ProveeDao {

	List<Provee> getProveeList();

	Provee getProveeById(Long idProvee);

	Provee getProveeByName(String nameProvee);

	void updateProvee(Provee provee);

	void createProvee(Provee provee);

	void removeProvee(Long idProvee);

}
