package com.mengxk.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by mengxk on 2018/7/25.
 */
public class UserControllerTest {

    @Autowired
    UserController userController;

    @Test
    public void user() throws Exception {
        UserController userController2 = new UserController();
        userController2.user();
    }

}