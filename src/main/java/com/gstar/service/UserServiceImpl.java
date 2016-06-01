package com.gstar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gstar.bean.User;
import com.gstar.mapper.UserMapper;

/**
 * 用户接口实现
 * @author luoshengsha
 *
 * 2016年5月12日-下午2:44:32
 */
@Service
@Cacheable(value="my-ehcache")
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserMapper mapper;
	
	@Override
	public void save(User user) {
		mapper.save(user);
	}

	@CacheEvict(value="my-ehcache",key="#user.getName()")
	@Override
	public void update(User user) {
		mapper.update(user);
	}

	@Cacheable(value="my-ehcache")
	@Override
	public User find(int id) {
		return mapper.find(id);
	}

	@Cacheable(value="my-ehcache")
	@Override
	public List<User> query() {
		return mapper.query();
	}

}
