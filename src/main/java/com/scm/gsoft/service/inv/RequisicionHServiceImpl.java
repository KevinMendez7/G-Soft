package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.RequisicionHDao;
import com.scm.gsoft.domain.inv.RequisicionH;

@Service("RequisicionHService")
@Transactional
public class RequisicionHServiceImpl implements RequisicionHService {

	@Autowired
	private RequisicionHDao _requisicionHDao;

	@Override
	public List<RequisicionH> getRequisicionHList(){
		return _requisicionHDao.getRequisicionHList();
	}

	@Override
	public RequisicionH getRequisicionHById(Long idRequisicionH) {
		// TODO Auto-generated method stub
		return _requisicionHDao.getRequisicionHById(idRequisicionH);
	}

	@Override
	public RequisicionH getRequisicionHByName(String nameRequisicionH) {
		// TODO Auto-generated method stub
		return _requisicionHDao.getRequisicionHByName(nameRequisicionH);
	}

	@Override
	public void updateRequisicionH(RequisicionH requisicionH) {

		_requisicionHDao.updateRequisicionH(requisicionH);

	}

	@Override
	public void createRequisicionH(RequisicionH requisicionH) {

		_requisicionHDao.createRequisicionH(requisicionH);

	}

	@Override
	public void removeRequisicionH(Long idRequisicionH) {

		_requisicionHDao.removeRequisicionH(idRequisicionH);

	}

}
