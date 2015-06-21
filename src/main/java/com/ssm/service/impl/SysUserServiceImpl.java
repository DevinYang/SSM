package com.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.UserMapper;
import com.ssm.domain.User;
import com.ssm.service.IUserService;

@Service("userService")
public class SysUserServiceImpl implements IUserService {
	@Resource
	private UserMapper userMapper;
	
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userMapper.selectByPrimaryKey(userId);
	}
	

}
