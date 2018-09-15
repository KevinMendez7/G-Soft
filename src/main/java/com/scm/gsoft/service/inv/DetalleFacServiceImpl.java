package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.DetalleFacDao;
import com.scm.gsoft.domain.inv.DetalleFac;

@Service("DetalleFacService")
@Transactional
public class DetalleFacServiceImpl implements DetalleFacService {

	@Autowired
	private DetalleFacDao _detalleFacDao;

	@Override
	public List<DetalleFac> getDetalleFacList(){
		return _detalleFacDao.getDetalleFacList();
	}

	@Override
	public DetalleFac getDetalleFacById(Long idDetalleFac) {
		// TODO Auto-generated method stub
		return _detalleFacDao.getDetalleFacById(idDetalleFac);
	}

	@Override
	public DetalleFac getDetalleFacByName(String nameDetalleFac) {
		// TODO Auto-generated method stub
		return _detalleFacDao.getDetalleFacByName(nameDetalleFac);
	}

	@Override
	public void updateDetalleFac(DetalleFac detalleFac) {

		_detalleFacDao.updateDetalleFac(detalleFac);

	}

	@Override
	public void createDetalleFac(DetalleFac detalleFac) {

		_detalleFacDao.createDetalleFac(detalleFac);

	}

	@Override
	public void removeDetalleFac(Long idDetalleFac) {

		_detalleFacDao.removeDetalleFac(idDetalleFac);

	}

}
