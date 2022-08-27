package com.fagner.workshop.services;

import com.fagner.workshop.domain.User;
import com.fagner.workshop.dto.UserDTO;
import com.fagner.workshop.repository.UseRepository;
import com.fagner.workshop.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UseRepository repository;

    public List<User> findAll(){
       return repository.findAll();

    };

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user){
      return repository.insert(user);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(),userDTO.getName(), userDTO.getEmail());
    }

}
