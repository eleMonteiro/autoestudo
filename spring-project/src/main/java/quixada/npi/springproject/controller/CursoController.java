package quixada.npi.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.model.Usuario;
import quixada.npi.springproject.service.CursoService;
import quixada.npi.springproject.service.UsuarioService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping("")
	public ResponseEntity<List<Curso>> findAll() {
		return ResponseEntity.ok(cursoService.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Curso> find(@PathVariable Integer id) {
		return ResponseEntity.ok(cursoService.findById(id));
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Curso> create(@RequestBody Curso curso) {
		return ResponseEntity.ok(cursoService.saveCurso(curso));
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<Curso> update(@PathVariable Integer id, @RequestBody Curso curso){
		Curso c = cursoService.findById(curso.getId());
		if( c != null)
			return ResponseEntity.ok(cursoService.saveCurso(curso));
		return null;
	}

	@DeleteMapping("/deletar/{id}")
	public void delete(@PathVariable Integer id) {
		Curso curso = cursoService.findById(id);
		cursoService.delete(curso);
		ResponseEntity.ok().build();
	}
}