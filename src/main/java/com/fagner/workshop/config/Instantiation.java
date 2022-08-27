package com.fagner.workshop.config;

import com.fagner.workshop.domain.User;
import com.fagner.workshop.repository.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UseRepository useRepository;

    @Override
    public void run(String... args) throws Exception {

        useRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        useRepository.saveAll(Arrays.asList(maria,alex,bob));
    }
}
