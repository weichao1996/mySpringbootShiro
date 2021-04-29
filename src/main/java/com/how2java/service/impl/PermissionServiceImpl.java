package com.how2java.service.impl;

import com.how2java.mapper.PermissionMapper;
import com.how2java.mapper.RolePermissionMapper;
import com.how2java.pojo.*;
import com.how2java.service.PermissionService;
import com.how2java.service.RoleService;
import com.how2java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionMapper permissionMapper;
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	RolePermissionMapper rolePermissionMapper;

	@Override
	public Set<String> listPermissions(String userName) {
		Set<String> result = new HashSet<>();
		List<Role> roles = roleService.listRoles(userName);

		List<RolePermission> rolePermissions = new ArrayList<>();

		for (Role role : roles) {
			RolePermissionExample example = new RolePermissionExample();
			example.createCriteria().andRidEqualTo(role.getId());
			List<RolePermission> rps = rolePermissionMapper.selectByExample(example);
			rolePermissions.addAll(rps);
		}

		for (RolePermission rolePermission : rolePermissions) {
			Permission p = permissionMapper.selectByPrimaryKey(rolePermission.getPid());
			result.add(p.getName());
		}

		return result;
	}

	@Override
	public void add(Permission u) {
		permissionMapper.insert(u);
	}

	@Override
	public void delete(Long id) {
		permissionMapper.deleteById(id);
		rolePermissionMapper.deleteByPid(id);
	}

	@Override
	public void update(Permission u) {
		permissionMapper.updateById(u);
	}

	@Override
	public Permission get(Long id) {
		return permissionMapper.selectById(id);
	}



	@Override
	public List<Permission> list(Role role) {

		return permissionMapper.getPermissionByRid(role.getId());
	}




//-------------------------------------
	@Override
	public boolean needInterceptor(String requestURI) {
		List<Permission> ps = permissionMapper.getAll();
		for (Permission p : ps) {
			if (p.getUrl().equals(requestURI))
				return true;
		}
		return false;
	}

	@Override
	public Set<String> listPermissionURLs(String userName) {
		Set<String> result = new HashSet<>();

		List<Permission> permission = permissionMapper.listPermissionsByUserName(userName);
		for (Permission p : permission) {

			result.add(p.getUrl());
		}

		return result;
	}

	@Override
	public List<Permission> list() {

		return permissionMapper.getAll();

	}
}