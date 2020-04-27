package com.example.springaop.service;

import com.example.springaop.pojo.UserInfoDTO;

public interface UserService {
    //使用的是redis操作 string
    UserInfoDTO getUserInfo(String userUid);

    //使用的是 redis 操作 hash
    UserInfoDTO getUserInfoByUserUid(String userUid);
}
