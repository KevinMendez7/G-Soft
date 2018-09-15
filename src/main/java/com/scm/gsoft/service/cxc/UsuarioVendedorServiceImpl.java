package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.UsuarioVendedorDao;
import com.scm.gsoft.domain.cxc.UsuarioVendedor;

@Service("UsuarioVendedorService")
@Transactional
public class UsuarioVendedorServiceImpl implements UsuarioVendedorService {

	@Autowired
	private UsuarioVendedorDao _usuarioVendedorDao;

	@Override
	public List<UsuarioVendedor> getUsuarioVendedorList(){
		return _usuarioVendedorDao.getUsuarioVendedorList();
	}

	@Override
	public UsuarioVendedor getUsuarioVendedorById(Long idUsuarioVendedor) {
		// TODO Auto-generated method stub
		return _usuarioVendedorDao.getUsuarioVendedorById(idUsuarioVendedor);
	}

	@Override
	public UsuarioVendedor getUsuarioVendedorByName(String nameUsuarioVendedor) {
		// TODO Auto-generated method stub
		return _usuarioVendedorDao.getUsuarioVendedorByName(nameUsuarioVendedor);
	}

	@Override
	public void updateUsuarioVendedor(UsuarioVendedor usuarioVendedor) {

		_usuarioVendedorDao.updateUsuarioVendedor(usuarioVendedor);

	}

	@Override
	public void createUsuarioVendedor(UsuarioVendedor usuarioVendedor) {

		_usuarioVendedorDao.createUsuarioVendedor(usuarioVendedor);

	}

	@Override
	public void removeUsuarioVendedor(Long idUsuarioVendedor) {

		_usuarioVendedorDao.removeUsuarioVendedor(idUsuarioVendedor);

	}

}
