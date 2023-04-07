package com.projetomongo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetomongo.demo.Service.PostService;
import com.projetomongo.demo.controller.util.URL;
import com.projetomongo.demo.entidade.Post;

@RestController
@RequestMapping("/posts")
public class PostController {
    

    @Autowired
    private PostService service;


    
    @GetMapping("/{id}")
    public ResponseEntity<Post>findById(@PathVariable String id){ 
           Post obj = service.findById(id);    
        return ResponseEntity.ok().body(obj);
    }


    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "")String text){ 
           text = URL.decodeParam(text);
           List<Post> list =service.findByTitle(text);
     return ResponseEntity.ok().body(list);
    }
}