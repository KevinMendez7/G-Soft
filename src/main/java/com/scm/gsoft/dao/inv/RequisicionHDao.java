package com.scm.gsoft.dao.inv;

import java.util.List;

import com.scm.gsoft.domain.inv.RequisicionH;

public interface RequisicionHDao {

	List<RequisicionH> getRequisicionHList();

	RequisicionH getRequisicionHById(Long idRequisicionH);

	RequisicionH getRequisicionHByName(String nameRequisicionH);

	void updateRequisicionH(RequisicionH requisicionH);

	void createRequisicionH(RequisicionH requisicionH);

	void removeRequisicionH(Long idRequisicionH);

}
