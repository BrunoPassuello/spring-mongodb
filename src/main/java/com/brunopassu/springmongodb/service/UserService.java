package com.brunopassu.springmongodb.service;

import com.brunopassu.springmongodb.domain.User;
import com.brunopassu.springmongodb.dto.UserDTO;
import com.brunopassu.springmongodb.repository.UserRepository;
import com.brunopassu.springmongodb.service.exception.ObjectNotFoundException;
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

    public User findById(String id) {
        User user = userRepository.findById(id).get();
        if (user.getClass() != User.class) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public User fromDTO(UserDTO userDTO) {
        User user = new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail());
        return user;
    }

    public void delete(String id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public User update(User user) {
        User newObj = userRepository.findById(user.getId()).get();
        updateData(newObj, user);
        return userRepository.save(newObj);
    }

    public void updateData(User newObj, User user) {
        newObj.setName(user.getName());
        newObj.setEmail(user.getEmail());
    }
}
