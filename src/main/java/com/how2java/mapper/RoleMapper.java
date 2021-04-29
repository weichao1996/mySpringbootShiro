package com.how2java.mapper;

import com.how2java.pojo.Role;
import com.how2java.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleMapper {

	int insert(Role record);

	List<Role> getRoleByUser(User user);

	List<Role> getAll();

    void deleteById(Long id);

	Role getById(Long id);

    void update(Role u);
}