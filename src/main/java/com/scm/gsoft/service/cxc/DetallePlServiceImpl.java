package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.DetallePlDao;
import com.scm.gsoft.domain.cxc.DetallePl;

@Service("DetallePlService")
@Transactional
public class DetallePlServiceImpl implements DetallePlService {

	@Autowired
	private DetallePlDao _detallePlDao;

	@Override
	public List<DetallePl> getDetallePlList(){
		return _detallePlDao.getDetallePlList();
	}

	@Override
	public DetallePl getDetallePlById(Long idDetallePl) {
		// TODO Auto-generated method stub
		return _detallePlDao.getDetallePlById(idDetallePl);
	}

	@Override
	public DetallePl getDetallePlByName(String nameDetallePl) {
		// TODO Auto-generated method stub
		return _detallePlDao.getDetallePlByName(nameDetallePl);
	}

	@Override
	public void updateDetallePl(DetallePl detallePl) {

		_detallePlDao.updateDetallePl(detallePl);

	}

	@Override
	public void createDetallePl(DetallePl detallePl) {

		_detallePlDao.createDetallePl(detallePl);

	}

	@Override
	public void removeDetallePl(Long idDetallePl) {

		_detallePlDao.removeDetallePl(idDetallePl);

	}

}
