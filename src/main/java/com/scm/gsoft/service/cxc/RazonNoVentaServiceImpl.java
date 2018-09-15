package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.RazonNoVentaDao;
import com.scm.gsoft.domain.cxc.RazonNoVenta;

@Service("RazonNoVentaService")
@Transactional
public class RazonNoVentaServiceImpl implements RazonNoVentaService {

	@Autowired
	private RazonNoVentaDao _razonNoVentaDao;

	@Override
	public List<RazonNoVenta> getRazonNoVentaList(){
		return _razonNoVentaDao.getRazonNoVentaList();
	}

	@Override
	public RazonNoVenta getRazonNoVentaById(Long idRazonNoVenta) {
		// TODO Auto-generated method stub
		return _razonNoVentaDao.getRazonNoVentaById(idRazonNoVenta);
	}

	@Override
	public RazonNoVenta getRazonNoVentaByName(String nameRazonNoVenta) {
		// TODO Auto-generated method stub
		return _razonNoVentaDao.getRazonNoVentaByName(nameRazonNoVenta);
	}

	@Override
	public void updateRazonNoVenta(RazonNoVenta razonNoVenta) {

		_razonNoVentaDao.updateRazonNoVenta(razonNoVenta);

	}

	@Override
	public void createRazonNoVenta(RazonNoVenta razonNoVenta) {

		_razonNoVentaDao.createRazonNoVenta(razonNoVenta);

	}

	@Override
	public void removeRazonNoVenta(Long idRazonNoVenta) {

		_razonNoVentaDao.removeRazonNoVenta(idRazonNoVenta);

	}

}
