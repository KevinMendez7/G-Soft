package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.MarcasDao;
import com.scm.gsoft.domain.inv.Marcas;

@Service("MarcasService")
@Transactional
public class MarcasServiceImpl implements MarcasService {

	@Autowired
	private MarcasDao _marcasDao;

	@Override
	public List<Marcas> getMarcasList(){
		return _marcasDao.getMarcasList();
	}

	@Override
	public Marcas getMarcasById(Long idMarcas) {
		// TODO Auto-generated method stub
		return _marcasDao.getMarcasById(idMarcas);
	}

	@Override
	public Marcas getMarcasByName(String nameMarcas) {
		// TODO Auto-generated method stub
		return _marcasDao.getMarcasByName(nameMarcas);
	}

	@Override
	public void updateMarcas(Marcas marcas) {

		_marcasDao.updateMarcas(marcas);

	}

	@Override
	public void createMarcas(Marcas marcas) {

		_marcasDao.createMarcas(marcas);

	}

	@Override
	public void removeMarcas(Long idMarcas) {

		_marcasDao.removeMarcas(idMarcas);

	}

}
