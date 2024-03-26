/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ejemplo.narciso.nvargamu.controller;

import com.example.ejemplo.narciso.nvargamu.dto.Usuario;
import com.example.ejemplo.narciso.nvargamu.response.UsuarioResponse;
import com.example.ejemplo.narciso.nvargamu.service.UsuariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Nar
 */
@Controller
@RequestMapping("/user")
public class UsuariosController {

    @Autowired
    private final UsuariosService service;

    public UsuariosController(UsuariosService service) {
        this.service = service;
    }

    @GetMapping("/getUserId")
    public ResponseEntity<Page<Usuario>> getUser(@RequestParam(defaultValue = "0")int pag, @RequestParam(defaultValue = "10")int size) {

        return service.getUser(pag, size);
    }

    @GetMapping("/getUserById/{dni}")
    public ResponseEntity<UsuarioResponse> getUserById(@PathVariable Long dni) {

        return service.getUserId(dni);
    }

    @PostMapping("/createUser")
    public ResponseEntity<UsuarioResponse> createUser(@RequestBody Usuario usuario) {

        return service.createUser(usuario);
        
    }
    
    @PutMapping("/updateUser")
    public ResponseEntity<UsuarioResponse> updateUser(@RequestBody Usuario usuario) {

        return service.updateUser(usuario);
        
    }
    
    @DeleteMapping("/deleteUser/{dni}")
    public ResponseEntity<UsuarioResponse> eliminarUsuario(@PathVariable Long dni) {
        return service.deleteUser(dni);
    }

}
