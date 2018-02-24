package com.bios.portal.daos;

import java.util.List;

import com.bios.portal.entities.User;;


public interface UserDao {
	boolean insertUser(User inq) throws Exception;
	boolean updateUser(User inq) throws Exception;
	List< User > getUserList(String userId) throws Exception;
}
