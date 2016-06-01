package com.gstar.service;

import java.util.List;

import com.gstar.bean.User;

/**
 * 用户接口
 * @author luoshengsha
 *
 * 2016年5月12日-下午2:02:50
 */
public interface UserService {
	
	public void save(User user);
	
	public void update(User user);
	
	public User find(int id);
	
	public List<User> query();
}
