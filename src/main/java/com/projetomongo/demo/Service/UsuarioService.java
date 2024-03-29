package com.projetomongo.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetomongo.demo.Service.exception.ObjectNotFoundException;
import com.projetomongo.demo.UsuarioRepositorio.UsuarioRepository;
import com.projetomongo.demo.dto.UsuarioDTO;
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
    

}
 
public void delete(String id){
    findById(id);
    repository.deleteById(id);
}


public Usuario insert(Usuario obj){
    return repository.insert(obj);
}


public Usuario update(Usuario obj){

         Usuario newObj = findById(obj.getId());
         updateData(newObj, obj);
         return repository.save(newObj);
}

private void updateData(Usuario newObj, Usuario obj) {

    newObj.setName(obj.getName());
    newObj.setEmail(obj.getEmail());
}



public Usuario fromDTO(UsuarioDTO objDto){
    return new Usuario(objDto.getId(),objDto.getName(), objDto.getEmail());
}
}


