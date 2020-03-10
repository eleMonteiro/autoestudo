package quixada.npi.springproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import quixada.npi.springproject.model.Usuario;
import quixada.npi.springproject.repository.UsuarioRepository;
import quixada.npi.springproject.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
    
    @Override
    public List<Usuario> findAll() {
    	return usuarioRepository.findAll();
    }

	@Override
	public Usuario saveUser(Usuario usuario) {
		usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario findById(Integer id) {
		return usuarioRepository.findById(id).get();
	}

	@Override
	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);;
	}

	@Override
	public List<Usuario> findByCursoId(Integer id) {
		return usuarioRepository.findByCursoId(id);
	}

}
