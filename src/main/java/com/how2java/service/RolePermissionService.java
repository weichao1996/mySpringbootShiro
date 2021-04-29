package com.how2java.service;

import com.how2java.pojo.Role;

public interface RolePermissionService {
	public void setPermissions(Role role, long[] permissionIds);
}