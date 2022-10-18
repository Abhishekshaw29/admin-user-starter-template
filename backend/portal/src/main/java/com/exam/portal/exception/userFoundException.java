package com.exam.portal.exception;

public class userFoundException extends Exception {
    
    public userFoundException(String string) {
        super("User with this username is already in DB !! try with different");
    }

}
