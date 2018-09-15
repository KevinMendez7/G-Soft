package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.TarjetaDao;
import com.scm.gsoft.domain.cxc.Tarjeta;

@Service("TarjetaService")
@Transactional
public class TarjetaServiceImpl implements TarjetaService {

	@Autowired
	private TarjetaDao _tarjetaDao;

	@Override
	public List<Tarjeta> getTarjetaList(){
		return _tarjetaDao.getTarjetaList();
	}

	@Override
	public Tarjeta getTarjetaById(Long idTarjeta) {
		// TODO Auto-generated method stub
		return _tarjetaDao.getTarjetaById(idTarjeta);
	}

	@Override
	public Tarjeta getTarjetaByName(String nameTarjeta) {
		// TODO Auto-generated method stub
		return _tarjetaDao.getTarjetaByName(nameTarjeta);
	}

	@Override
	public void updateTarjeta(Tarjeta tarjeta) {

		_tarjetaDao.updateTarjeta(tarjeta);

	}

	@Override
	public void createTarjeta(Tarjeta tarjeta) {

		_tarjetaDao.createTarjeta(tarjeta);

	}

	@Override
	public void removeTarjeta(Long idTarjeta) {

		_tarjetaDao.removeTarjeta(idTarjeta);

	}

}
