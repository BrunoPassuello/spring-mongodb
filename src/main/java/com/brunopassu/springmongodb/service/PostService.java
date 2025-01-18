package com.brunopassu.springmongodb.service;

import com.brunopassu.springmongodb.domain.Post;
import com.brunopassu.springmongodb.domain.User;
import com.brunopassu.springmongodb.dto.UserDTO;
import com.brunopassu.springmongodb.repository.PostRepository;
import com.brunopassu.springmongodb.repository.UserRepository;
import com.brunopassu.springmongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    //instancia o userRepository -> Injeção de dependencia
    private PostRepository postRepository;

    public Post findById(String id) {
        Post post = postRepository.findById(id).get();
        if (post == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return post;
    }


}
