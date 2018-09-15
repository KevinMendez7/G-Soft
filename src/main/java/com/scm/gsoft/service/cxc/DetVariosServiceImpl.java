package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.DetVariosDao;
import com.scm.gsoft.domain.cxc.DetVarios;

@Service("DetVariosService")
@Transactional
public class DetVariosServiceImpl implements DetVariosService {

	@Autowired
	private DetVariosDao _detVariosDao;

	@Override
	public List<DetVarios> getDetVariosList(){
		return _detVariosDao.getDetVariosList();
	}

	@Override
	public DetVarios getDetVariosById(Long idDetVarios) {
		// TODO Auto-generated method stub
		return _detVariosDao.getDetVariosById(idDetVarios);
	}

	@Override
	public DetVarios getDetVariosByName(String nameDetVarios) {
		// TODO Auto-generated method stub
		return _detVariosDao.getDetVariosByName(nameDetVarios);
	}

	@Override
	public void updateDetVarios(DetVarios detVarios) {

		_detVariosDao.updateDetVarios(detVarios);

	}

	@Override
	public void createDetVarios(DetVarios detVarios) {

		_detVariosDao.createDetVarios(detVarios);

	}

	@Override
	public void removeDetVarios(Long idDetVarios) {

		_detVariosDao.removeDetVarios(idDetVarios);

	}

}
