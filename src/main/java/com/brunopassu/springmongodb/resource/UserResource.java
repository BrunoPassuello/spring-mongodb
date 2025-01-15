package com.brunopassu.springmongodb.resource;

import com.brunopassu.springmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users") //caminho do end point
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
         User maria = new User("1", "Maria", "Maria@gmail.com");
         User alex = new User("2", "Alex", "Alex@gmail.com");
         List<User> list = new ArrayList<User>();
         list.addAll(Arrays.asList(maria, alex));
         return ResponseEntity.ok().body(list);
    }
}
