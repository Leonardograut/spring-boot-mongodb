package com.projetomongo.demo.dto;

import java.io.Serializable;

import com.projetomongo.demo.entidade.Usuario;

public class AuthorDTO  implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String id ;
    private String name;

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



    public AuthorDTO(){

    }

    public AuthorDTO(Usuario obj){
       id = obj.getId();
       name = obj.getName();
        

    }
}
