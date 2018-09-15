package com.scm.gsoft.service.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.RequisicionH;

public interface RequisicionHService {

	List<RequisicionH> getRequisicionHList();

	RequisicionH getRequisicionHById(Long idRequisicionH);

	RequisicionH getRequisicionHByName(String nameRequisicionH);

	void updateRequisicionH(RequisicionH requisicionH);

	void createRequisicionH(RequisicionH requisicionH);

	void removeRequisicionH(Long idRequisicionH);

}
