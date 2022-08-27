package com.fagner.workshop.resources;

import com.fagner.workshop.domain.User;
import com.fagner.workshop.dto.UserDTO;
import com.fagner.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {


    @Autowired
    private UserService service;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){

        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findAById(@PathVariable String id){

        User obj = service.findById(id);

        return ResponseEntity.ok().body(new UserDTO(obj) );
    }


    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
        User user = service.fromDTO(objDTO);
         user = service.insert(user);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
         return  ResponseEntity.created(uri).build();
    }

    /* public ResponseEntity<List<User>> findAll(){
       User fagner = new User("1", "Fagner", "fagner.avila@gmail");
        User avila = new User("2", "agner", "agner.avila@gmail");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(fagner,avila));
        return ResponseEntity.ok().body(list);*/
}