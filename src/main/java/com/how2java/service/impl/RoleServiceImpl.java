package com.how2java.service.impl;

import com.how2java.mapper.RoleMapper;
import com.how2java.mapper.RolePermissionMapper;
import com.how2java.mapper.UserRoleMapper;
import com.how2java.pojo.*;
import com.how2java.service.RoleService;
import com.how2java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleMapper roleMapper;
	@Autowired
	UserRoleMapper userRoleMapper;
	@Autowired
	UserService userService;
	@Autowired
	RolePermissionMapper rolePermissionMapper;

	@Override
	public Set<String> listRoleNames(String userName) {
		Set<String> result = new HashSet<>();
		List<Role> roles = listRoles(userName);
		for (Role role : roles) {
			result.add(role.getName());
		}
		return result;
	}

	@Override
	public List<Role> listRoles(String userName) {
		List<Role> roles = new ArrayList<>();
		User user = userService.getByName(userName);
		if (null == user)
			return roles;

		roles = listRoles(user);
		return roles;
	}

	@Override
	public void add(Role u) {
		roleMapper.insert(u);
	}

	@Override
	public void delete(Long id) {
		roleMapper.deleteById(id);
		rolePermissionMapper.deleteByRid(id);
		userRoleMapper.deleteByRid(id);
	}

	@Override
	public void update(Role u) {
		roleMapper.update(u);
	}

	@Override
	public Role get(Long id) {
		return roleMapper.getById(id);
	}





	@Override
	public List<Role> list() {

		return roleMapper.getAll();

	}

	@Override
	public List<Role> listRoles(User user) {


		return roleMapper.getRoleByUser(user);
	}

}