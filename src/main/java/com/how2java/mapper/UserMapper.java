package com.how2java.mapper;

import com.how2java.pojo.User;
import com.how2java.pojo.UserExample;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	//--------------------------------
	User getByName(String name);

    List<User> getAll();

    User getUserById(Long id);

    void deleteById(Long id);
}