package com.fagner.workshop.resources;

import com.fagner.workshop.domain.Post;
import com.fagner.workshop.resources.util.URL;
import com.fagner.workshop.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {


    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }


    // http://localhost:8080/posts/titlesearch?text=m%20dia
    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByText(@RequestParam(value = "text", defaultValue = "") String text){
         text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
    ){
        text = URL.decodeParam(text);
       Date min = URL.convertDate(minDate, new Date(0L));
       Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = postService.fullSearch(text,min,max);
        return ResponseEntity.ok().body(list);
    }


}
