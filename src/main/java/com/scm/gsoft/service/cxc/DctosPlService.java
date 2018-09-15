package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.DctosPl;

public interface DctosPlService {

	List<DctosPl> getDctosPlList();

	DctosPl getDctosPlById(Long idDctosPl);

	DctosPl getDctosPlByName(String nameDctosPl);

	void updateDctosPl(DctosPl dctosPl);

	void createDctosPl(DctosPl dctosPl);

	void removeDctosPl(Long idDctosPl);

}
