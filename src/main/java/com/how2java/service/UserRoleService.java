package com.how2java.service;

import com.how2java.pojo.User;

public interface UserRoleService {

	public void setRoles(User user, long[] roleIds);

}