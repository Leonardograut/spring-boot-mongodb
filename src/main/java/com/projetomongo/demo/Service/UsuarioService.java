package com.projetomongo.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetomongo.demo.Service.exception.ObjectNotFoundException;
import com.projetomongo.demo.UsuarioRepositorio.UsuarioRepository;
import com.projetomongo.demo.entidade.Usuario;

@Service
public class UsuarioService {
    
@Autowired
private UsuarioRepository repository;

public List<Usuario>findAll(){
  
    return repository.findAll();
 
}

public Usuario findById(String id){
    Optional<Usuario> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    

}}
