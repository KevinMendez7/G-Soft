package com.scm.gsoft.service.cxc;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scm.gsoft.dao.cxc.UsuarioDao;
import com.scm.gsoft.domain.cxc.Usuario;

@Qualifier("UsuarioServiceCxc")
@Service("UsuarioServiceCxc")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	@Qualifier("UsuarioDaoCxc")
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
