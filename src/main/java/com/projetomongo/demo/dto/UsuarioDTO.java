package com.projetomongo.demo.dto;

import java.io.Serializable;

import com.projetomongo.demo.entidade.Usuario;

public class UsuarioDTO implements Serializable {  
    private static final long serialVersionUID =1L;

    private String  id;
    
    private String name;
    private String email;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsuarioDTO(){

    }


    public UsuarioDTO(Usuario obj){
        id = obj.getId();
        name =obj.getName();
        email = obj.getEmail();
    }
}
