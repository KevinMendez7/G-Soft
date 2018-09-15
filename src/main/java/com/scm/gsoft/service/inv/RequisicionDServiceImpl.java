package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.RequisicionDDao;
import com.scm.gsoft.domain.inv.RequisicionD;

@Service("RequisicionDService")
@Transactional
public class RequisicionDServiceImpl implements RequisicionDService {

	@Autowired
	private RequisicionDDao _requisicionDDao;

	@Override
	public List<RequisicionD> getRequisicionDList(){
		return _requisicionDDao.getRequisicionDList();
	}

	@Override
	public RequisicionD getRequisicionDById(Long idRequisicionD) {
		// TODO Auto-generated method stub
		return _requisicionDDao.getRequisicionDById(idRequisicionD);
	}

	@Override
	public RequisicionD getRequisicionDByName(String nameRequisicionD) {
		// TODO Auto-generated method stub
		return _requisicionDDao.getRequisicionDByName(nameRequisicionD);
	}

	@Override
	public void updateRequisicionD(RequisicionD requisicionD) {

		_requisicionDDao.updateRequisicionD(requisicionD);

	}

	@Override
	public void createRequisicionD(RequisicionD requisicionD) {

		_requisicionDDao.createRequisicionD(requisicionD);

	}

	@Override
	public void removeRequisicionD(Long idRequisicionD) {

		_requisicionDDao.removeRequisicionD(idRequisicionD);

	}

}
