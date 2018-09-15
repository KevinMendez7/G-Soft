package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.ModulosDao;
import com.scm.gsoft.domain.inv.Modulos;

@Service("ModulosService")
@Transactional
public class ModulosServiceImpl implements ModulosService {

	@Autowired
	private ModulosDao _modulosDao;

	@Override
	public List<Modulos> getModulosList(){
		return _modulosDao.getModulosList();
	}

	@Override
	public Modulos getModulosById(Long idModulos) {
		// TODO Auto-generated method stub
		return _modulosDao.getModulosById(idModulos);
	}

	@Override
	public Modulos getModulosByName(String nameModulos) {
		// TODO Auto-generated method stub
		return _modulosDao.getModulosByName(nameModulos);
	}

	@Override
	public void updateModulos(Modulos modulos) {

		_modulosDao.updateModulos(modulos);

	}

	@Override
	public void createModulos(Modulos modulos) {

		_modulosDao.createModulos(modulos);

	}

	@Override
	public void removeModulos(Long idModulos) {

		_modulosDao.removeModulos(idModulos);

	}

}
