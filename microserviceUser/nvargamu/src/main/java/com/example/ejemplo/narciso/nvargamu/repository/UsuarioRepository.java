/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ejemplo.narciso.nvargamu.repository;

import com.example.ejemplo.narciso.nvargamu.dto.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nar
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public void save(Optional<Usuario> usuarioOptional);
    
    Page<Usuario> findAll(Pageable pageable);
    
}
