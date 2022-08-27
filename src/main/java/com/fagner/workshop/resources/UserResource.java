package com.fagner.workshop.resources;

import com.fagner.workshop.domain.User;
import com.fagner.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {


    @Autowired
    private UserService service;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
       /* User fagner = new User("1", "Fagner", "fagner.avila@gmail");
        User avila = new User("2", "agner", "agner.avila@gmail");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(fagner,avila)); */
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


}
