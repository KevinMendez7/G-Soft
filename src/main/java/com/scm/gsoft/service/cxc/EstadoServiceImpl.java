package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.EstadoDao;
import com.scm.gsoft.domain.cxc.Estado;

@Service("EstadoService")
@Transactional
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private EstadoDao _estadoDao;

	@Override
	public List<Estado> getEstadoList(){
		return _estadoDao.getEstadoList();
	}

	@Override
	public Estado getEstadoById(Long idEstado) {
		// TODO Auto-generated method stub
		return _estadoDao.getEstadoById(idEstado);
	}

	@Override
	public Estado getEstadoByName(String nameEstado) {
		// TODO Auto-generated method stub
		return _estadoDao.getEstadoByName(nameEstado);
	}

	@Override
	public void updateEstado(Estado estado) {

		_estadoDao.updateEstado(estado);

	}

	@Override
	public void createEstado(Estado estado) {

		_estadoDao.createEstado(estado);

	}

	@Override
	public void removeEstado(Long idEstado) {

		_estadoDao.removeEstado(idEstado);

	}

}
