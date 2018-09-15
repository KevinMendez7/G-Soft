package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.LineaDao;
import com.scm.gsoft.domain.inv.Linea;

@Service("LineaService")
@Transactional
public class LineaServiceImpl implements LineaService {

	@Autowired
	private LineaDao _lineaDao;

	@Override
	public List<Linea> getLineaList(){
		return _lineaDao.getLineaList();
	}

	@Override
	public Linea getLineaById(Long idLinea) {
		// TODO Auto-generated method stub
		return _lineaDao.getLineaById(idLinea);
	}

	@Override
	public Linea getLineaByName(String nameLinea) {
		// TODO Auto-generated method stub
		return _lineaDao.getLineaByName(nameLinea);
	}

	@Override
	public void updateLinea(Linea linea) {

		_lineaDao.updateLinea(linea);

	}

	@Override
	public void createLinea(Linea linea) {

		_lineaDao.createLinea(linea);

	}

	@Override
	public void removeLinea(Long idLinea) {

		_lineaDao.removeLinea(idLinea);

	}

}
