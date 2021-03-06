package com.scm.gsoft.service.cxc;

import java.util.List;

import com.scm.gsoft.domain.cxc.SegL;

public interface SegLService {

	List<SegL> getSegLList();

	SegL getSegLById(Long idSegL);

	SegL getSegLByName(String nameSegL);

	void updateSegL(SegL segL);

	void createSegL(SegL segL);

	void removeSegL(Long idSegL);

}
