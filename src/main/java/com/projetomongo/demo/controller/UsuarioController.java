package com.projetomongo.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetomongo.demo.entidade.Usuario;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    

  @GetMapping()
    public ResponseEntity<List<Usuario>>findAll(){
        Usuario maria = new Usuario("1", "Maria Veronica", "maria@gmail.com");
        Usuario leo =  new Usuario("2", "leonardo", "leonardo@hotmail.com");
        List<Usuario> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria,leo));

        return ResponseEntity.ok().body(list);
    }
}
