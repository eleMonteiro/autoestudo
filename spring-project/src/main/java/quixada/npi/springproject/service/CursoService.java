package quixada.npi.springproject.service;

import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.model.Usuario;

import java.util.List;

public interface CursoService {

    Curso findByNome(String nome);
    Curso findById(Integer id);
    List<Curso> findAll();
    Curso saveCurso(Curso curso);
    void delete(Curso curso);

}
