package com.example.book.service;

import com.example.book.model.User;


public interface AuthService {

    User register( User userToAdd );
    String login( String username, String password );
}