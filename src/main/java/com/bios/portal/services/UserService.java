package com.bios.portal.services;

import java.util.List;

import com.bios.portal.entities.User;


public interface UserService {
	boolean addUser(User user) throws Exception;
	boolean modifyUser(User user) throws Exception;
	List< User > fetchUserList(String uid) throws Exception;

}
