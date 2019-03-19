package com.example.book.service.impl;

import com.example.book.model.MyUser;
import com.example.book.repository.MyUserRepository;
import com.example.book.service.UserService;
import com.example.book.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MyUserRepository myUserRepository;

    @Override
    public boolean addUser(MyUser user) {
        user.setPassword(Utils.bCryptPasswordEncoder().encode(user.getPassword()));
        myUserRepository.save(user);
        return true;
    }
}
