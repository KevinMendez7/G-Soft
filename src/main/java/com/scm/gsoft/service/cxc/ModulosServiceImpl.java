package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.ModulosDao;
import com.scm.gsoft.domain.cxc.Modulos;

@Qualifier("ModulosServiceCxc")
@Service("ModulosServiceCxc")
@Transactional
public class ModulosServiceImpl implements ModulosService {

	@Autowired
	@Qualifier("ModulosDaoCxc")
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
