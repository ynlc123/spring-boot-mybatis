package com.gstar.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gstar.bean.User;
import com.gstar.service.UserService;

/**
 * 用户控制器
 * @author luoshengsha
 *
 * 2016年5月12日-下午5:10:28
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/query")
	public String query() {
		PageHelper.startPage(1, 2);
		List<User> users = userService.query();
		PageInfo<User> page = new PageInfo<User>(users);
		return ListToString(page.getList());
	}
	
	private static final String SEP1 = "#";
	public static String ListToString(List<?> list) {  
        StringBuffer sb = new StringBuffer();  
        if (list != null && list.size() > 0) {  
            for (int i = 0; i < list.size(); i++) {  
                if (list.get(i) == null || list.get(i) == "") {  
                    continue;  
                }  
                // 如果值是list类型则调用自己  
                if (list.get(i) instanceof List) {  
                    sb.append(ListToString((List<?>) list.get(i)));  
                    sb.append(SEP1);  
                } else {  
                    sb.append(list.get(i));  
                    sb.append(SEP1);  
                }  
            }  
        }  
        return "L" + sb.toString();  
    } 
}
