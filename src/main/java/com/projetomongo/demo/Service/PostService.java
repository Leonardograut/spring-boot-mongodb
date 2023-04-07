package com.projetomongo.demo.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetomongo.demo.Service.exception.ObjectNotFoundException;
import com.projetomongo.demo.UsuarioRepositorio.PostRepository;
import com.projetomongo.demo.entidade.Post;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        
    
    }

    public List<Post>findByTitle(String text){
        return postRepository.searchTitle(text);
    }


    public List<Post>fullsearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 *1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
