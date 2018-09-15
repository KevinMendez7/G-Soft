package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.MaestroDao;
import com.scm.gsoft.domain.cxc.Maestro;

@Qualifier("MaestroServiceCxc")
@Service("MaestroServiceCxc")
@Transactional
public class MaestroServiceImpl implements MaestroService {

	@Autowired
	@Qualifier("MaestroDaoCxc")
	private MaestroDao _maestroDao;

	@Override
	public List<Maestro> getMaestroList(){
		return _maestroDao.getMaestroList();
	}

	@Override
	public Maestro getMaestroById(Long idMaestro) {
		// TODO Auto-generated method stub
		return _maestroDao.getMaestroById(idMaestro);
	}

	@Override
	public Maestro getMaestroByName(String nameMaestro) {
		// TODO Auto-generated method stub
		return _maestroDao.getMaestroByName(nameMaestro);
	}

	@Override
	public void updateMaestro(Maestro maestro) {

		_maestroDao.updateMaestro(maestro);

	}

	@Override
	public void createMaestro(Maestro maestro) {

		_maestroDao.createMaestro(maestro);

	}

	@Override
	public void removeMaestro(Long idMaestro) {

		_maestroDao.removeMaestro(idMaestro);

	}

}
