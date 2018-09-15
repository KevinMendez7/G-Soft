package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.TipoDao;
import com.scm.gsoft.domain.cxc.Tipo;

@Qualifier("TipoServiceCxc")
@Service("TipoServiceCxc")
@Transactional
public class TipoServiceImpl implements TipoService {

	@Autowired
	@Qualifier("TipoDaoCxc")
	private TipoDao _tipoDao;

	@Override
	public List<Tipo> getTipoList(){
		return _tipoDao.getTipoList();
	}

	@Override
	public Tipo getTipoById(Long idTipo) {
		// TODO Auto-generated method stub
		return _tipoDao.getTipoById(idTipo);
	}

	@Override
	public Tipo getTipoByName(String nameTipo) {
		// TODO Auto-generated method stub
		return _tipoDao.getTipoByName(nameTipo);
	}

	@Override
	public void updateTipo(Tipo tipo) {

		_tipoDao.updateTipo(tipo);

	}

	@Override
	public void createTipo(Tipo tipo) {

		_tipoDao.createTipo(tipo);

	}

	@Override
	public void removeTipo(Long idTipo) {

		_tipoDao.removeTipo(idTipo);

	}

}
