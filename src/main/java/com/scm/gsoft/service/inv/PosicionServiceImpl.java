package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.PosicionDao;
import com.scm.gsoft.domain.inv.Posicion;

@Service("PosicionService")
@Transactional
public class PosicionServiceImpl implements PosicionService {

	@Autowired
	private PosicionDao _posicionDao;

	@Override
	public List<Posicion> getPosicionList(){
		return _posicionDao.getPosicionList();
	}

	@Override
	public Posicion getPosicionById(Long idPosicion) {
		// TODO Auto-generated method stub
		return _posicionDao.getPosicionById(idPosicion);
	}

	@Override
	public Posicion getPosicionByName(String namePosicion) {
		// TODO Auto-generated method stub
		return _posicionDao.getPosicionByName(namePosicion);
	}

	@Override
	public void updatePosicion(Posicion posicion) {

		_posicionDao.updatePosicion(posicion);

	}

	@Override
	public void createPosicion(Posicion posicion) {

		_posicionDao.createPosicion(posicion);

	}

	@Override
	public void removePosicion(Long idPosicion) {

		_posicionDao.removePosicion(idPosicion);

	}

}
