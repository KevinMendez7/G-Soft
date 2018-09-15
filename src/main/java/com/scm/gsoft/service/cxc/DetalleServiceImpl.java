package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.DetalleDao;
import com.scm.gsoft.domain.cxc.Detalle;

@Service("DetalleService")
@Transactional
public class DetalleServiceImpl implements DetalleService {

	@Autowired
	private DetalleDao _detalleDao;

	@Override
	public List<Detalle> getDetalleList(){
		return _detalleDao.getDetalleList();
	}

	@Override
	public Detalle getDetalleById(Long idDetalle) {
		// TODO Auto-generated method stub
		return _detalleDao.getDetalleById(idDetalle);
	}

	@Override
	public Detalle getDetalleByName(String nameDetalle) {
		// TODO Auto-generated method stub
		return _detalleDao.getDetalleByName(nameDetalle);
	}

	@Override
	public void updateDetalle(Detalle detalle) {

		_detalleDao.updateDetalle(detalle);

	}

	@Override
	public void createDetalle(Detalle detalle) {

		_detalleDao.createDetalle(detalle);

	}

	@Override
	public void removeDetalle(Long idDetalle) {

		_detalleDao.removeDetalle(idDetalle);

	}

}
