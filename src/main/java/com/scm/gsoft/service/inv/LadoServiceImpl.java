package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.LadoDao;
import com.scm.gsoft.domain.inv.Lado;

@Service("LadoService")
@Transactional
public class LadoServiceImpl implements LadoService {

	@Autowired
	private LadoDao _ladoDao;

	@Override
	public List<Lado> getLadoList(){
		return _ladoDao.getLadoList();
	}

	@Override
	public Lado getLadoById(Long idLado) {
		// TODO Auto-generated method stub
		return _ladoDao.getLadoById(idLado);
	}

	@Override
	public Lado getLadoByName(String nameLado) {
		// TODO Auto-generated method stub
		return _ladoDao.getLadoByName(nameLado);
	}

	@Override
	public void updateLado(Lado lado) {

		_ladoDao.updateLado(lado);

	}

	@Override
	public void createLado(Lado lado) {

		_ladoDao.createLado(lado);

	}

	@Override
	public void removeLado(Long idLado) {

		_ladoDao.removeLado(idLado);

	}

}
