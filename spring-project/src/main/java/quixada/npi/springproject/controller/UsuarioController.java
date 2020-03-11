package quixada.npi.springproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import quixada.npi.springproject.service.impl.CursoServiceImpl;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CursoService cursoService;

    @GetMapping("")
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> find(@PathVariable Integer id) {
        Map<Object, Object> model = new HashMap<>();
        model.put("usuarios",usuarioService.findById(id));
        return ok(model);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        usuario.setCurso(cursoService.findById(usuario.getCurso().getId()));
        return ResponseEntity.ok(usuarioService.saveUser(usuario));
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario){
    	Usuario user = usuarioService.findById(usuario.getId());
    	if( user != null)
    		return ResponseEntity.ok(usuarioService.saveUser(usuario));
    	return null;
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        if (!usuario.isHabilitado()) {
            usuarioService.delete(usuario);
            ResponseEntity.ok().build();
        }
    }
}