package com.bios.portal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.daos.UserDao;
import com.bios.portal.entities.User;


@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	public boolean addUser(User inq) throws Exception {
		return userDao.insertUser(inq);
	}

	public boolean modifyUser(User inq) throws Exception {
		return userDao.updateUser(inq);
	}

	@Override
	public List<User> fetchUserList(String vin) throws Exception {
		return (List < User >)userDao.getUserList(vin);
	}

}
