package com.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.dao.UserDaoImpl;
import com.homework.entity.User;
@Service
public class EmailServiceForUserImpl implements EmailServiceForUser {
	@Autowired
    UserDaoImpl userDaoImpl;
	@Override
	public void saveUser(User user) {
	  	userDaoImpl.saveUser(user);
	}

}
