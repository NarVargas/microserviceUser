/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ejemplo.narciso.nvargamu.response;

import com.example.ejemplo.narciso.nvargamu.dto.Usuario;

/**
 *
 * @author Nar
 */
public class UsuarioResponse {
    
    private Usuario usuario;
    private String mensaje;

    public UsuarioResponse(Usuario usuario, String mensaje) {
        this.usuario = usuario;
        this.mensaje = mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
