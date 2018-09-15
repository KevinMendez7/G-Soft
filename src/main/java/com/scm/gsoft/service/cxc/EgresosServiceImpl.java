package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.EgresosDao;
import com.scm.gsoft.domain.cxc.Egresos;

@Service("EgresosService")
@Transactional
public class EgresosServiceImpl implements EgresosService {

	@Autowired
	private EgresosDao _egresosDao;

	@Override
	public List<Egresos> getEgresosList(){
		return _egresosDao.getEgresosList();
	}

	@Override
	public Egresos getEgresosById(Long idEgresos) {
		// TODO Auto-generated method stub
		return _egresosDao.getEgresosById(idEgresos);
	}

	@Override
	public Egresos getEgresosByName(String nameEgresos) {
		// TODO Auto-generated method stub
		return _egresosDao.getEgresosByName(nameEgresos);
	}

	@Override
	public void updateEgresos(Egresos egresos) {

		_egresosDao.updateEgresos(egresos);

	}

	@Override
	public void createEgresos(Egresos egresos) {

		_egresosDao.createEgresos(egresos);

	}

	@Override
	public void removeEgresos(Long idEgresos) {

		_egresosDao.removeEgresos(idEgresos);

	}

}
