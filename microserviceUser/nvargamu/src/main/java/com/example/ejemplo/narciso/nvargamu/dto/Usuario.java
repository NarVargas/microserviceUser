/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ejemplo.narciso.nvargamu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nar
 */
@Table(name = "usuarios")
@Entity
public class Usuario {
    
    @Id
    // En caso de querer el id por orden correlativo se añadiria
    // @GeneratedValue
    @JsonProperty("dni")
    private Long dni;

    @JsonProperty("nombre")
    private String nombre;
    
    @JsonProperty("apellidos")
    private String apellidos;
    
    @JsonProperty("edad")
    private Integer edad;
    
    @ElementCollection
    @JsonProperty("hijos")
    private List<String> hijos;
    
    public Usuario(){
    }
    
    public Usuario(String nombre, String apellidos, Integer edad, List<String> hijos)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.hijos = hijos; 
        
    }
    
    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<String> getHijos() {
        return hijos;
    }

    public void setHijos(List<String> hijos) {
        this.hijos = hijos;
    }
}
