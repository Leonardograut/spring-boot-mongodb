package com.projetomongo.demo.UsuarioRepositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetomongo.demo.entidade.Usuario;

@Repository
public interface UsuarioRepository  extends  MongoRepository<Usuario,String> {
    
}
