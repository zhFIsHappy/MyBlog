package com.zhfan.blog.dao.pojo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class SysUser {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String account;

    private Integer admin;

    private String avatar;

    private Long createDate;

    private Integer deleted;

    private String email;

    private Long lastLogin;

    private String mobilePhoneNumber;

    private String nickname;

    private String password;

    private String salt;

    private String status;
}
