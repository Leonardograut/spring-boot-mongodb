package com.projetomongo.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projetomongo.demo.UsuarioRepositorio.UsuarioRepository;
import com.projetomongo.demo.entidade.Usuario;

@Configuration
public class Instatiation  implements CommandLineRunner {


   @Autowired
   private UsuarioRepository uRepository;


    @Override
    public void run(String... args0) throws Exception {
        
          uRepository.deleteAll();
        

         Usuario leonardo = new Usuario(null, "Leonardo Nascimento", "leonardo@gmail.com");
         Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
         Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");


      uRepository.saveAll(Arrays.asList(leonardo,alex,bob));

         
    }
    
}
