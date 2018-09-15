package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.VentasDao;
import com.scm.gsoft.domain.cxc.Ventas;

@Service("VentasService")
@Transactional
public class VentasServiceImpl implements VentasService {

	@Autowired
	private VentasDao _ventasDao;

	@Override
	public List<Ventas> getVentasList(){
		return _ventasDao.getVentasList();
	}

	@Override
	public Ventas getVentasById(Long idVentas) {
		// TODO Auto-generated method stub
		return _ventasDao.getVentasById(idVentas);
	}

	@Override
	public Ventas getVentasByName(String nameVentas) {
		// TODO Auto-generated method stub
		return _ventasDao.getVentasByName(nameVentas);
	}

	@Override
	public void updateVentas(Ventas ventas) {

		_ventasDao.updateVentas(ventas);

	}

	@Override
	public void createVentas(Ventas ventas) {

		_ventasDao.createVentas(ventas);

	}

	@Override
	public void removeVentas(Long idVentas) {

		_ventasDao.removeVentas(idVentas);

	}

}
