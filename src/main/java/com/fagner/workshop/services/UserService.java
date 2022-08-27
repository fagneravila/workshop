package com.fagner.workshop.services;

import com.fagner.workshop.domain.User;
import com.fagner.workshop.repository.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UseRepository repository;

    public List<User> findAll(){
       return repository.findAll();

    };

}
