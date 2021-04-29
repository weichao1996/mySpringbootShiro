package com.how2java.mapper;

import com.how2java.pojo.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {

	int insert(UserRole record);

    void deleteByUserId(Long id);

    void deleteByRid(Long id);
}