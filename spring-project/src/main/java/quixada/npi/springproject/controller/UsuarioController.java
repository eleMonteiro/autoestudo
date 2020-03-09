package quixada.npi.springproject.controller;

import java.util.List;
import java.util.Optional;

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

import quixada.npi.springproject.model.Usuario;
import quixada.npi.springproject.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Usuario>> find(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.saveUser(usuario));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario){
    	Usuario user = usuarioService.findById(id).get();
    	user.setEmail(usuario.getEmail());
    	user.setNome(usuario.getNome());
    	user.setHabilitado(usuario.isHabilitado());
    	
    	return ResponseEntity.ok(usuarioService.saveUser(user));
    }
    
    @DeleteMapping("/excluir/{id}")
    public void delete(@PathVariable Integer id){
    	Usuario usuario = usuarioService.findById(id).get();
    	usuarioService.delete(usuario);
    	ResponseEntity.ok().build();
    }
    
}