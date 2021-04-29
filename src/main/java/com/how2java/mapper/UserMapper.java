package com.how2java.mapper;

import com.how2java.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {

	int insert(User record);

	int updateByPrimaryKeySelective(User record);

	User getByName(String name);

    List<User> getAll();

    User getUserById(Long id);

    void deleteById(Long id);
}