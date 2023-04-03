package com.projetomongo.demo.controller;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.projetomongo.demo.Service.UsuarioService;
import com.projetomongo.demo.dto.UsuarioDTO;
import com.projetomongo.demo.entidade.Usuario;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    

 @Autowired
 private UsuarioService uService;

    @GetMapping("/")
    public ResponseEntity<List<UsuarioDTO>>findAll(){   
        List<Usuario> list = uService.findAll();
        List<UsuarioDTO>listDto = list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
