package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.DetalleRecDao;
import com.scm.gsoft.domain.cxc.DetalleRec;

@Service("DetalleRecService")
@Transactional
public class DetalleRecServiceImpl implements DetalleRecService {

	@Autowired
	private DetalleRecDao _detalleRecDao;

	@Override
	public List<DetalleRec> getDetalleRecList(){
		return _detalleRecDao.getDetalleRecList();
	}

	@Override
	public DetalleRec getDetalleRecById(Long idDetalleRec) {
		// TODO Auto-generated method stub
		return _detalleRecDao.getDetalleRecById(idDetalleRec);
	}

	@Override
	public DetalleRec getDetalleRecByName(String nameDetalleRec) {
		// TODO Auto-generated method stub
		return _detalleRecDao.getDetalleRecByName(nameDetalleRec);
	}

	@Override
	public void updateDetalleRec(DetalleRec detalleRec) {

		_detalleRecDao.updateDetalleRec(detalleRec);

	}

	@Override
	public void createDetalleRec(DetalleRec detalleRec) {

		_detalleRecDao.createDetalleRec(detalleRec);

	}

	@Override
	public void removeDetalleRec(Long idDetalleRec) {

		_detalleRecDao.removeDetalleRec(idDetalleRec);

	}

}
