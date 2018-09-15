package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.ArticulosDao;
import com.scm.gsoft.domain.inv.Articulos;

@Service("ArticulosService")
@Transactional
public class ArticulosServiceImpl implements ArticulosService {

	@Autowired
	private ArticulosDao _articulosDao;

	@Override
	public List<Articulos> getArticulosList(){
		return _articulosDao.getArticulosList();
	}

	@Override
	public Articulos getArticulosById(Long idArticulos) {
		// TODO Auto-generated method stub
		return _articulosDao.getArticulosById(idArticulos);
	}

	@Override
	public Articulos getArticulosByName(String nameArticulos) {
		// TODO Auto-generated method stub
		return _articulosDao.getArticulosByName(nameArticulos);
	}

	@Override
	public void updateArticulos(Articulos articulos) {

		_articulosDao.updateArticulos(articulos);

	}

	@Override
	public void createArticulos(Articulos articulos) {

		_articulosDao.createArticulos(articulos);

	}

	@Override
	public void removeArticulos(Long idArticulos) {

		_articulosDao.removeArticulos(idArticulos);

	}

}
