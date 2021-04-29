package com.how2java.service.impl;

import com.how2java.mapper.UserMapper;
import com.how2java.mapper.UserRoleMapper;
import com.how2java.pojo.User;
import com.how2java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	@Autowired
	UserRoleMapper userRoleMapper;


	@Override
	public void add(User u) {
		userMapper.insert(u);
	}

	@Override
	public void delete(Long id) {
		userMapper.deleteById(id);
		userRoleMapper.deleteByUserId(id);
	}

	@Override
	public void update(User u) {
		userMapper.updateByPrimaryKeySelective(u);
	}



	@Override
	public List<User> list() {
		return userMapper.getAll();

	}

	@Override
	public User getByName(String name) {

		return userMapper.getByName(name);
	}

	@Override
	public User get(Long id) {
		return userMapper.getUserById(id);
	}
}