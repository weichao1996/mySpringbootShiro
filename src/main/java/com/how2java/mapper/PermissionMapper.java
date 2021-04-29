package com.how2java.mapper;

import com.how2java.pojo.Permission;
import com.how2java.pojo.PermissionExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Permission record);

	int insertSelective(Permission record);

	List<Permission> selectByExample(PermissionExample example);

	Permission selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Permission record);

	int updateByPrimaryKey(Permission record);

    List<Permission> getAll();

	List<Permission> listPermissionsByUserName(String userName);

    List<Permission> getPermissionByRid(Long id);

	Permission selectById(Long id);

	void updateById(Permission u);

	void deleteById(Long id);
}