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
    public ResponseEntity<Usuario> find(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        usuario.setId(usuarioService.findAll().size()+10);
        return ResponseEntity.ok(usuarioService.saveUser(usuario));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario){
    	Usuario user = usuarioService.findById(usuario.getId());
    	return ResponseEntity.ok(usuarioService.saveUser(usuario));
    }
    
    @DeleteMapping("/excluir/{id}")
    public void delete(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);

        if (!usuario.isHabilitado()) {
            usuarioService.delete(usuario);
            ResponseEntity.ok().build();
        }
    }
}