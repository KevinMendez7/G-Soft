package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.EstanteriasDao;
import com.scm.gsoft.domain.inv.Estanterias;

@Service("EstanteriasService")
@Transactional
public class EstanteriasServiceImpl implements EstanteriasService {

	@Autowired
	private EstanteriasDao _estanteriasDao;

	@Override
	public List<Estanterias> getEstanteriasList(){
		return _estanteriasDao.getEstanteriasList();
	}

	@Override
	public Estanterias getEstanteriasById(Long idEstanterias) {
		// TODO Auto-generated method stub
		return _estanteriasDao.getEstanteriasById(idEstanterias);
	}

	@Override
	public Estanterias getEstanteriasByName(String nameEstanterias) {
		// TODO Auto-generated method stub
		return _estanteriasDao.getEstanteriasByName(nameEstanterias);
	}

	@Override
	public void updateEstanterias(Estanterias estanterias) {

		_estanteriasDao.updateEstanterias(estanterias);

	}

	@Override
	public void createEstanterias(Estanterias estanterias) {

		_estanteriasDao.createEstanterias(estanterias);

	}

	@Override
	public void removeEstanterias(Long idEstanterias) {

		_estanteriasDao.removeEstanterias(idEstanterias);

	}

}
