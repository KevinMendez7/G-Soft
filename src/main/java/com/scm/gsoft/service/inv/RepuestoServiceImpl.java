package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.RepuestoDao;
import com.scm.gsoft.domain.inv.Repuesto;

@Service("RepuestoService")
@Transactional
public class RepuestoServiceImpl implements RepuestoService {

	@Autowired
	private RepuestoDao _repuestoDao;

	@Override
	public List<Repuesto> getRepuestoList(){
		return _repuestoDao.getRepuestoList();
	}

	@Override
	public Repuesto getRepuestoById(Long idRepuesto) {
		// TODO Auto-generated method stub
		return _repuestoDao.getRepuestoById(idRepuesto);
	}

	@Override
	public Repuesto getRepuestoByName(String nameRepuesto) {
		// TODO Auto-generated method stub
		return _repuestoDao.getRepuestoByName(nameRepuesto);
	}

	@Override
	public void updateRepuesto(Repuesto repuesto) {

		_repuestoDao.updateRepuesto(repuesto);

	}

	@Override
	public void createRepuesto(Repuesto repuesto) {

		_repuestoDao.createRepuesto(repuesto);

	}

	@Override
	public void removeRepuesto(Long idRepuesto) {

		_repuestoDao.removeRepuesto(idRepuesto);

	}

}
