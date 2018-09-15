package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.SegLDao;
import com.scm.gsoft.domain.cxc.SegL;

@Service("SegLService")
@Transactional
public class SegLServiceImpl implements SegLService {

	@Autowired
	private SegLDao _segLDao;

	@Override
	public List<SegL> getSegLList(){
		return _segLDao.getSegLList();
	}

	@Override
	public SegL getSegLById(Long idSegL) {
		// TODO Auto-generated method stub
		return _segLDao.getSegLById(idSegL);
	}

	@Override
	public SegL getSegLByName(String nameSegL) {
		// TODO Auto-generated method stub
		return _segLDao.getSegLByName(nameSegL);
	}

	@Override
	public void updateSegL(SegL segL) {

		_segLDao.updateSegL(segL);

	}

	@Override
	public void createSegL(SegL segL) {

		_segLDao.createSegL(segL);

	}

	@Override
	public void removeSegL(Long idSegL) {

		_segLDao.removeSegL(idSegL);

	}

}
