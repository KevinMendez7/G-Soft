package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.MDetalleDao;
import com.scm.gsoft.domain.cxc.MDetalle;

@Service("MDetalleService")
@Transactional
public class MDetalleServiceImpl implements MDetalleService {

	@Autowired
	private MDetalleDao _mDetalleDao;

	@Override
	public List<MDetalle> getMDetalleList(){
		return _mDetalleDao.getMDetalleList();
	}

	@Override
	public MDetalle getMDetalleById(Long idMDetalle) {
		// TODO Auto-generated method stub
		return _mDetalleDao.getMDetalleById(idMDetalle);
	}

	@Override
	public MDetalle getMDetalleByName(String nameMDetalle) {
		// TODO Auto-generated method stub
		return _mDetalleDao.getMDetalleByName(nameMDetalle);
	}

	@Override
	public void updateMDetalle(MDetalle mDetalle) {

		_mDetalleDao.updateMDetalle(mDetalle);

	}

	@Override
	public void createMDetalle(MDetalle mDetalle) {

		_mDetalleDao.createMDetalle(mDetalle);

	}

	@Override
	public void removeMDetalle(Long idMDetalle) {

		_mDetalleDao.removeMDetalle(idMDetalle);

	}

}
