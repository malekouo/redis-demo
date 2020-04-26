package com.example.springaop.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class UserInfoDTO extends BaseDTO {
    @JSONField(name = "user_name")
    private String userName;

    @JSONField(name = "age")
    private String age;

    @JSONField(name = "user_phone")
    private String userPhone;
}
