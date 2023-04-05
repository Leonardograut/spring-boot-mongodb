package com.projetomongo.demo.UsuarioRepositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetomongo.demo.entidade.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    
}
