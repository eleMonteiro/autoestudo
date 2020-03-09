package quixada.npi.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quixada.npi.springproject.model.Curso;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    Curso findByNome(String nome);
    Optional<Curso> findById(Integer id);
    List<Curso> findAll();

}
