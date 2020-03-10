package quixada.npi.springproject.service;


import quixada.npi.springproject.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Usuario findByEmail(String email);

    List<Usuario> findAll();
    
    Usuario saveUser(Usuario usuario);

	Usuario findById(Integer id);

	void delete(Usuario usuario);

	List<Usuario> findByCursoId(Integer id);
    
}
