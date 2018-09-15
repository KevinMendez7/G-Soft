package com.scm.gsoft.dao.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.DctosPl;

public interface DctosPlDao {

	List<DctosPl> getDctosPlList();

	DctosPl getDctosPlById(Long idDctosPl);

	DctosPl getDctosPlByName(String nameDctosPl);

	void updateDctosPl(DctosPl dctosPl);

	void createDctosPl(DctosPl dctosPl);

	void removeDctosPl(Long idDctosPl);

}
