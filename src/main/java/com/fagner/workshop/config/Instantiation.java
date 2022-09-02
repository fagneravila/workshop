package com.fagner.workshop.config;

import com.fagner.workshop.domain.Post;
import com.fagner.workshop.domain.User;
import com.fagner.workshop.dto.AuthorDTO;
import com.fagner.workshop.dto.CommentDTO;
import com.fagner.workshop.repository.PostRepository;
import com.fagner.workshop.repository.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UseRepository useRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));



        useRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        useRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post p1 = new Post(null, sdf.parse("30/08/2022"),"Partiu viagem", "Vou viajar para sao paulo",new AuthorDTO(maria));
        Post p2 = new Post(null, sdf.parse("30/08/2022"),"Partiu viagem", "tou bem",new AuthorDTO(maria) );

        CommentDTO c1 = new CommentDTO("Boa Viagem!",sdf.parse("30/08/2022"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite",sdf.parse("20/08/2022"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um otimo dia!",sdf.parse("25/08/2022"), new AuthorDTO(alex));

        p1.getComments().addAll(Arrays.asList(c1,c2));
        p2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(p1,p2));

        maria.getPosts().addAll(Arrays.asList(p1,p1));
        useRepository.save(maria);

    }
}

