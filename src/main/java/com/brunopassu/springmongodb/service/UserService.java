package com.brunopassu.springmongodb.service;

import com.brunopassu.springmongodb.domain.User;
import com.brunopassu.springmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    //instancia o userRepository -> Injeção de dependencia
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();

    }
}
