package com.example.book.service;

import com.example.book.model.User;

/**
 * @www.codesheep.cn
 * 20190312
 */
public interface AuthService {

    User register( User userToAdd );
    String login( String username, String password );
}