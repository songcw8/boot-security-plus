package org.example.bootsecurityplus.model.mapper;

import org.apache.ibatis.annotations.*;
import org.example.bootsecurityplus.model.domain.SecurityUser;

@Mapper
public interface SecurityUserMapper {
    @Select(("SELECT * FROM SECURITY_USER WHERE username = #{username}"))
    SecurityUser findByUsername(String username);

    @Insert("INSERT INTO SECURITY_USER(username, password, role) values (#{username}, #{password}, #{role})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void insertUser(SecurityUser user);

}
