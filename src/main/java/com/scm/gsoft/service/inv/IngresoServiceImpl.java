package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.IngresoDao;
import com.scm.gsoft.domain.inv.Ingreso;

@Service("IngresoService")
@Transactional
public class IngresoServiceImpl implements IngresoService {

	@Autowired
	private IngresoDao _ingresoDao;

	@Override
	public List<Ingreso> getIngresoList(){
		return _ingresoDao.getIngresoList();
	}

	@Override
	public Ingreso getIngresoById(Long idIngreso) {
		// TODO Auto-generated method stub
		return _ingresoDao.getIngresoById(idIngreso);
	}

	@Override
	public Ingreso getIngresoByName(String nameIngreso) {
		// TODO Auto-generated method stub
		return _ingresoDao.getIngresoByName(nameIngreso);
	}

	@Override
	public void updateIngreso(Ingreso ingreso) {

		_ingresoDao.updateIngreso(ingreso);

	}

	@Override
	public void createIngreso(Ingreso ingreso) {

		_ingresoDao.createIngreso(ingreso);

	}

	@Override
	public void removeIngreso(Long idIngreso) {

		_ingresoDao.removeIngreso(idIngreso);

	}

}
