package pe.edu.upeu.apirest.controller;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.apirest.entity.Producto;


@RestController
public class ProductoController {
    @Autowired
    Service Service;

    @GetMapping("/")
    public String hola(){
        return "Hola";
    }
    @GetMapping("/readAll")
    public ResponseEntity<List<Producto>> readAll(){
    	List<Producto> Producto = new ArrayList<Producto>();
        try {
        	if(Producto.isEmpty())
        		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        	return new ResponseEntity<>(Producto,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
    }
    @PostMapping("/create")
    public ResponseEntity<Usuario> createUser(@Valid @RequestBody Usuario user){
    	try {
			Usuario usu = usuarioService.create(user);
			return new ResponseEntity<>(usu, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}        
    }
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUser(@PathVariable(value = "id") long id){
        Optional<Usuario> optional = usuarioService.readID(id);
        if(optional.isPresent()) {
        	return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        }else {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    	
    }
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable("id") long id, @RequestBody Usuario user){
    	Optional<Usuario> optional = usuarioService.readID(id);
    	if(optional.isPresent()) {
    		Usuario uu = optional.get();
    		uu.setNombre(user.getNombre());
    		uu.setClave(user.getClave());
    		return new ResponseEntity<>(usuarioService.create(uu),HttpStatus.OK);
    	}else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);    		 
    	}    	
    }
    @DeleteMapping("/usuario/eliminar/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable(value = "id") long id){
    	try {
			usuarioService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}        
    }
}