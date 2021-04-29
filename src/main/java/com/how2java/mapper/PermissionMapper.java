package com.how2java.mapper;

import com.how2java.pojo.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {

	int insert(Permission record);

	Permission selectByPrimaryKey(Long id);

	List<Permission> getAll();

	List<Permission> listPermissionsByUserName(String userName);

    List<Permission> getPermissionByRid(Long id);

	Permission selectById(Long id);

	void updateById(Permission u);

	void deleteById(Long id);
}