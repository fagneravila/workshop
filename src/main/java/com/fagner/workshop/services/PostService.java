package com.fagner.workshop.services;

import com.fagner.workshop.domain.Post;
import com.fagner.workshop.domain.User;
import com.fagner.workshop.repository.PostRepository;
import com.fagner.workshop.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService
{
    @Autowired
    private PostRepository repository;


    public List<Post> findAll(){
        return repository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ResourceNotFoundException("Post não encontrado"));
    }


    public List<Post> findByTitle(String text){
       return repository.findByTitleContainingIgnoreCase(text);
    }


}
