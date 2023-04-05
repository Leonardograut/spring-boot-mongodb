package com.projetomongo.demo.controller;


import java.net.URI;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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



    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO>findById(@PathVariable String id){ 
        
        Usuario obj = uService.findById(id);    
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }


    @PostMapping("/")
    public ResponseEntity<Void>insert(@RequestBody UsuarioDTO objDto){ 
        
        Usuario obj = uService.fromDTO(objDto);
        obj =uService.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }



    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable String id){ 
        
       uService.delete(id);    
        return ResponseEntity.noContent().build();
    }



}
