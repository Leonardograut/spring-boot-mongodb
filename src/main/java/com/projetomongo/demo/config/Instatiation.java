package com.projetomongo.demo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projetomongo.demo.UsuarioRepositorio.PostRepository;
import com.projetomongo.demo.UsuarioRepositorio.UsuarioRepository;
import com.projetomongo.demo.entidade.Post;
import com.projetomongo.demo.entidade.Usuario;

@Configuration
public class Instatiation  implements CommandLineRunner {




   

   @Autowired
   private UsuarioRepository uRepository;
    
   @Autowired
   private PostRepository postRepository;

    @Override
    public void run(String... args0) throws Exception {
        
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         sdf.setTimeZone(TimeZone.getTimeZone("GMT"));


          uRepository.deleteAll();
          postRepository.deleteAll();

         Usuario leonardo = new Usuario(null, "Leonardo Nascimento", "leonardo@gmail.com");
         Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
         Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");

         
        
         Post post1 = new Post(null, sdf.parse("21/03/2023"), "Bora Javeiro ", "Bora Progamar ate amanhecer",leonardo);
         Post post2 = new Post(null, sdf.parse("21/04/2022"), "Bora Sair ", "Tudo bem nao sei se vou",leonardo); 


      uRepository.saveAll(Arrays.asList(leonardo,alex,bob));
      postRepository.saveAll(Arrays.asList(post1,post2));

         
    }
    
}
