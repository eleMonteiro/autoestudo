package quixada.npi.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import quixada.npi.springproject.model.Usuario;

import java.util.List;
import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmail(String email);

    Optional<Usuario> findById(Integer id);

    List<Usuario> findByCursoId(Integer id);

    @Query("SELECT new Usuario(u.id, u.nome, u.email, u.habilitado) FROM Usuario u")
    List<Usuario> findAll();

}
