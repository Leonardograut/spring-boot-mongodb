package com.projetomongo.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.projetomongo.demo.Service.UsuarioService;
import com.projetomongo.demo.entidade.Usuario;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    

 @Autowired
 private UsuarioService uService;

    @GetMapping("/")
    public ResponseEntity<List<Usuario>>findAll(){
        
        List<Usuario> list = uService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
