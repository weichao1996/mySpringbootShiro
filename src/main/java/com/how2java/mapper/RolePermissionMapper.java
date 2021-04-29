package com.how2java.mapper;

import com.how2java.pojo.RolePermission;
import com.how2java.pojo.RolePermissionExample;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RolePermissionMapper {

	int insert(RolePermission record);

	List<RolePermission> selectByExample(RolePermissionExample example);

    void deleteByRid(Long id);

	void deleteByPid(Long id);
}