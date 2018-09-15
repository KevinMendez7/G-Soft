package com.scm.gsoft.service.inv;
// Generated 26/08/2018 02:38:20 AM by Hibernate Tools 4.3.1

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.inv.UsuarioDao;
import com.scm.gsoft.domain.inv.Usuario;

@Service("UsuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao _usuarioDao;

	@Override
	public List<Usuario> getUsuarioList(){
		return _usuarioDao.getUsuarioList();
	}

	@Override
	public Usuario getUsuarioById(Long idUsuario) {
		// TODO Auto-generated method stub
		return _usuarioDao.getUsuarioById(idUsuario);
	}

	@Override
	public Usuario getUsuarioByName(String nameUsuario) {
		// TODO Auto-generated method stub
		return _usuarioDao.getUsuarioByName(nameUsuario);
	}

	@Override
	public void updateUsuario(Usuario usuario) {

		_usuarioDao.updateUsuario(usuario);

	}

	@Override
	public void createUsuario(Usuario usuario) {

		_usuarioDao.createUsuario(usuario);

	}

	@Override
	public void removeUsuario(Long idUsuario) {

		_usuarioDao.removeUsuario(idUsuario);

	}

}
