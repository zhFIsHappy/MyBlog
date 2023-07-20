package com.zhfan.blog.service.impl;

import com.zhfan.blog.dao.mapper.SysUserMapper;
import com.zhfan.blog.dao.pojo.SysUser;
import com.zhfan.blog.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser findUserById(Long id) {
       SysUser  sysUser= sysUserMapper.selectById(id);
       if(sysUser == null ){
           sysUser = new SysUser();
           sysUser.setNickname("zhfan");
       }
       return sysUser;
    }
}
