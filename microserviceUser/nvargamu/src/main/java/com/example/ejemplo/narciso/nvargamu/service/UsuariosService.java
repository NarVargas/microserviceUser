/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ejemplo.narciso.nvargamu.service;

import com.example.ejemplo.narciso.nvargamu.dto.Usuario;
import com.example.ejemplo.narciso.nvargamu.repository.UsuarioRepository;
import com.example.ejemplo.narciso.nvargamu.response.UsuarioResponse;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Nar
 */
@Service
public class UsuariosService {

    @Autowired
    private UsuarioRepository repository;

    public ResponseEntity<UsuarioResponse> createUser(Usuario user) {
        
         Optional<Usuario> usuarioOptional = this.searchUser(user.getDni());
         
         if (usuarioOptional.isPresent()) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UsuarioResponse(null, "El usuario con ese dni ya ha sido creado"));
         }
         else
             repository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioResponse(user, "Usuario generado correctamente"));
    }

    public ResponseEntity<UsuarioResponse> getUserId(Long dni) {
         Optional<Usuario> usuarioOptional = this.searchUser (dni);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            return ResponseEntity.ok(new UsuarioResponse(usuario, null));

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UsuarioResponse(null, "El usuario con id " + dni + " no ha sido encontrado"));
        }
    }

    public ResponseEntity<Page<Usuario>> getUser(int pag, int size) {
        
        return ResponseEntity.status(HttpStatus.OK).body(this.obtenerUsuarios(pag, size));
    }

    public ResponseEntity<UsuarioResponse> deleteUser(Long dni) {
        Optional<Usuario> usuarioOptional = this.searchUser(dni);

        if (usuarioOptional.isPresent()) {
            repository.deleteById(dni);

            return ResponseEntity.ok(new UsuarioResponse(null, "Usuario eliminado correctamente"));

        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new UsuarioResponse(null, "El usuario con id " + dni + "no ha sido encontrado"));
        }

    }
    
    public ResponseEntity<UsuarioResponse> updateUser(Usuario user)
    {
         Optional<Usuario> usuarioOptional = this.searchUser(user.getDni());
         
        if (usuarioOptional.isPresent()) {
            usuarioOptional.get().setNombre(user.getNombre());
            usuarioOptional.get().setApellidos(user.getApellidos());
            usuarioOptional.get().setEdad(user.getEdad());
            usuarioOptional.get().setHijos(user.getHijos());
            
            Usuario usuarioActualizado = usuarioOptional.get();
            
            repository.save(usuarioActualizado);

            return ResponseEntity.ok(new UsuarioResponse(null, "Usuario modificado correctamente"));

        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new UsuarioResponse(null, "El usuario con id " + user.getDni() + "no ha sido encontrado"));
        }
    }

    public Optional<Usuario> searchUser(Long dni) {
        Optional<Usuario> usuarioOptional = repository.findById(dni);
        
        return usuarioOptional;
    }
    
    public Page<Usuario> obtenerUsuarios(int pagina, int tamaño) {
        Pageable pageable = PageRequest.of(pagina, tamaño);
        return repository.findAll(pageable);
    }

    public ResponseEntity<Page<Usuario>> getUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
